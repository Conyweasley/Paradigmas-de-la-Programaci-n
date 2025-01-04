import feed.Article;
import feed.Feed;
import httpRequest.httpRequester;
import namedEntity.NamedEntity;
import namedEntity.classes.Classes;
import namedEntity.heuristic.Heuristic;
import namedEntity.heuristic.QuickHeuristic;
import namedEntity.heuristic.RandomHeuristic;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import parser.RssParser;
import parser.SubscriptionParser;
import scala.Tuple2;
import subscription.SingleSubscription;
import subscription.Subscription;

import java.util.*;
import java.util.stream.Collectors;

public class FeedReaderMain {

    private static final String DEFAULT_FEED_TITLE = "Titulo";
    private static final String HEURISTIC_FEED_TITLE = "Heuristica";
    private static final String HEURISTIC_QUICK = "Quick";
    private static final String HEURISTIC_RANDOM = "Random";
    private static final String HELP_MESSAGE = "Please, call this program in correct way: FeedReader [-ne]";

    public static void main(String[] args) {
        System.out.println("************* FeedReader version 1.0 *************");
        // Instancias
        SubscriptionParser parser = new SubscriptionParser();
        RssParser rssParser = new RssParser();
        httpRequester hr = new httpRequester();
        Map<String, NamedEntity> namedEntityMap = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        // Lista de suscripciones
        Subscription listOfRSS = parser.getFeedUrls("rss");

        if (args.length == 0) {
            processDefaultFeed(hr, rssParser, listOfRSS);
        } else if (args.length == 1) {
            if (args[0].equals("-ne")) {
                String heuristicOption = getUserInputForHeuristic();
                Heuristic heuristic = createHeuristic(heuristicOption);
                Feed feed = new Feed(HEURISTIC_FEED_TITLE);

                List<NamedEntity> namedEntities = processHeuristicFeed(hr, rssParser, listOfRSS, heuristic, feed, namedEntityMap);

                if (namedEntities != null) {
                    for (NamedEntity namedEntity : namedEntities) {
                        namedEntity.prettyPrint();
                    }
                    System.out.println("********* Named entity classes frequency *********");
                    Classes.printClasses();
                    System.out.println("************* FeedReader version 1.0 *************");
                }

            } else if (args[0].equals("-search")) {
                System.out.println("Introduce una palabra, luego veremos en que articulos está, y cuantas ocurrencias de esta misma existe por articulo: ");
                String word = scan.nextLine();
                indiceInvertido(hr, rssParser, listOfRSS, word);
            }
        } else {
            printHelp();
        }
    }

    private static void processDefaultFeed(httpRequester httpRequester, RssParser rssParser, Subscription listOfRSS) {
        Feed feed = new Feed(DEFAULT_FEED_TITLE);

        for (SingleSubscription subscriptionElem : listOfRSS.getSubscriptionsList()) {
            String responseXML = httpRequester.getFeedRss(subscriptionElem.getUrl());
            feed.setArticleList(rssParser.parserForRss(responseXML));
            feed.prettyPrint();
        }
    }

    private static String getUserInputForHeuristic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHOOSE THE HEURISTIC\n1) QUICK HEURISTIC\n2) RANDOM HEURISTIC");

        int option = scanner.nextInt();
        while (option != 1 && option != 2) {
            System.out.println("Invalid heuristic option");
            option = scanner.nextInt();
        }

        if (option == 1) {
            return HEURISTIC_QUICK;
        } else {
            return HEURISTIC_RANDOM;
        }
    }

    private static Heuristic createHeuristic(String heuristicOption) {
        if (heuristicOption == null) {
            return null;
        }

        switch (heuristicOption) {
            case HEURISTIC_QUICK:
                return new QuickHeuristic();
            case HEURISTIC_RANDOM:
                return new RandomHeuristic();
            default:
                return null;
        }
    }

    private static List<NamedEntity> processHeuristicFeed(httpRequester httpRequester, RssParser rssParser,
                                                          Subscription listOfRSS, Heuristic heuristic, Feed feed,
                                                          Map<String, NamedEntity> namedEntityMap) {
        spark.SparkUtils.createSparkContext();
        JavaSparkContext sparkContext = spark.SparkUtils.getSparkContext();

        // Paso de Map (flatMapToPair): Generar pares clave-valor para cada entidad nombrada
        JavaPairRDD<String, Integer> namedEntityPairs = sparkContext.parallelize(listOfRSS.getSubscriptionsList())
                .flatMapToPair(subscriptionElem -> {
                    String responseXML = httpRequester.getFeedRss(subscriptionElem.getUrl());
                    feed.setArticleList(rssParser.parserForRss(responseXML));

                    List<Tuple2<String, Integer>> pairs = new ArrayList<>();
                    for (Article article : feed.getArticleList()) {
                        for (String word : article.getText().split(" ")) {
                            if (heuristic.isEntity(word)) {
                                pairs.add(new Tuple2<>(word, 1));
                            }
                        }
                    }
                    return pairs.iterator();
                });

        // Paso de Reduce (collect): Contar la frecuencia de cada entidad nombrada
        JavaPairRDD<String, Integer> namedEntityCounts = namedEntityPairs.reduceByKey(Integer::sum);

        List<NamedEntity> namedEntities = namedEntityCounts.collect().stream()
                .map(pair -> {
                    String word = pair._1();
                    NamedEntity namedEnt = namedEntityMap.computeIfAbsent(word, w -> {
                        NamedEntity newNamedEntity = new NamedEntity(w, new ArrayList<>(), 0);
                        Classes.setCategories(newNamedEntity);
                        namedEntity.FrequencyClasses.incrementFrequency(newNamedEntity.getCategories());
                        return newNamedEntity;
                    });

                    namedEnt.incFrequency();
                    return namedEnt;
                })
                .collect(Collectors.toList());

        spark.SparkUtils.stopSparkContext();
        return namedEntities;
    }


    private static void indiceInvertido(httpRequester hr, RssParser rssParser, Subscription listOfRSS, String word) {
        Feed f = new Feed("DEFAULT_FEED_TITLE");

        // <Articulo, VecesQueAparece>
        Map<Article, Integer> hashMap = new HashMap<>();

        spark.SparkUtils.createSparkContext();
        // Crear una configuración de Spark
        JavaSparkContext sparkContext = spark.SparkUtils.getSparkContext();

        for (SingleSubscription subscriptionElem : listOfRSS.getSubscriptionsList()) {
            String responseXML = hr.getFeedRss(subscriptionElem.getUrl());
            f.setArticleList(rssParser.parserForRss(responseXML));

            JavaRDD<Article> articleRDD = sparkContext.parallelize(f.getArticleList());

            // Crear un par clave-valor para cada palabra encontrada en los artículos
            JavaPairRDD<Article, Integer> wordCountRDD = articleRDD.flatMapToPair(article -> {
                List<Tuple2<Article, Integer>> wordCounts = new ArrayList<>();
                for (String art_word : article.getText().split(" ")) {
                    if (art_word.equals(word)) {
                        wordCounts.add(new Tuple2<>(article, 1));
                    }
                }

                return wordCounts.iterator();
            });

            // Calcular la frecuencia de cada artículo
            JavaPairRDD<Article, Integer> articleFrequencyRDD = wordCountRDD.reduceByKey(Integer::sum);

            // Crear el HashMap final <Article, Frequency> a partir del RDD
            hashMap = new HashMap<>(articleFrequencyRDD.collectAsMap());
        }

        // Crear una lista auxiliar para almacenar las entradas del HashMap
        List<Map.Entry<Article, Integer>> lista = new ArrayList<>(hashMap.entrySet());

        // Ordenar la lista por los valores de forma descendente
        lista.sort(Comparator.comparing(Map.Entry<Article, Integer>::getValue).reversed());

        // Imprimir los elementos ordenados
        for (Map.Entry<Article, Integer> entry : lista) {
            Article articulo = entry.getKey();
            int vecesQueAparece = entry.getValue();
            articulo.prettyPrint();
            System.out.println("Cantidad de veces que aparece la palabra '" + word + "' : " + vecesQueAparece + "\n");
        }

        if (lista.isEmpty()) {
            System.out.println("No se encontraron resultados para la palabra '" + word + "'");
        }
        spark.SparkUtils.stopSparkContext();
    }

    private static void printHelp() {
        System.out.println(HELP_MESSAGE);
    }
}