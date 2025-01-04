import feed.Article;
import feed.Feed;
import httpRequest.httpRequester;
import namedEntity.NamedEntity;
import namedEntity.classes.namedEntityClasses.*;
import namedEntity.classes.topic.*;
import namedEntity.heuristic.Heuristic;
import namedEntity.heuristic.QuickHeuristic;
import namedEntity.heuristic.RandomHeuristic;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import parser.RssParser;
import parser.SubscriptionParser;
import subscription.SingleSubscription;
import subscription.Subscription;

import java.util.*;

public class FeedReaderMain {

	private static void printHelp(){
		System.out.println("Please, call this program in correct way: FeedReader [-ne]");
	}

	public static void main(String[] args) {
		System.out.println("************* FeedReader version 1.0 *************");

		JavaSparkContext sc = new JavaSparkContext("local", "FeedReaderMain");

		// Instancias
		SubscriptionParser parser = new SubscriptionParser();
		RssParser rssParser = new RssParser();
		httpRequester hr = new httpRequester();
		Map<String, NamedEntity> namedEntityMap = new HashMap<>();

		// Lista de suscripciones
		Subscription listOfRSS = parser.getFeedUrls("rss");

		if (args.length == 0) {
			Feed f = new Feed("Titulo!");
			for (SingleSubscription subscriptionElem : listOfRSS.getSubscriptionsList()) {
				String responseXML = hr.getFeedRss(subscriptionElem.getUrl());
				f.setArticleList(rssParser.parserForRss(responseXML));
				f.prettyPrint();
			}

		} else if (args.length == 1) {

			Scanner scanner = new Scanner(System.in);
			System.out.println("CHOICE THE HEURISTIC\n1) QUICK HEURISTIC\n2) RANDOM HEURISTIC");
			int option = scanner.nextInt();
			final Heuristic heuristic = (option == 1) ? new QuickHeuristic() : (option == 2) ? new RandomHeuristic() : null;
			Feed f = new Feed("Heuristica");


			for (SingleSubscription subscriptionElem : listOfRSS.getSubscriptionsList()) {
				String responseXML = hr.getFeedRss(subscriptionElem.getUrl());
				f.setArticleList(rssParser.parserForRss(responseXML));

				JavaRDD<Article> articlesRDD = sc.parallelize(f.getArticleList());

				JavaRDD<String> wordsRDD = articlesRDD.flatMap(article -> Arrays.asList(article.getText().split(" ")).iterator());

				JavaRDD<String> namedEntityWordsRDD = wordsRDD.filter(word -> heuristic.isEntity(word));

				Map<String, Long> wordCountMap = namedEntityWordsRDD.countByValue();

				for (Map.Entry<String, Long> entry : wordCountMap.entrySet()) {
					String word = entry.getKey();
					Long count = entry.getValue();

					if (namedEntityMap.containsKey(word)) {
						NamedEntity namedEntity = namedEntityMap.get(word);
						namedEntity.incFrequency();
					} else {
						NamedEntity namedEntity = new NamedEntity(word, new ArrayList<>(), 1);
						setCategories(namedEntity);
						namedEntityMap.put(word, namedEntity);
					}
				}
			}

			for (Map.Entry<String, NamedEntity> mapElem : namedEntityMap.entrySet()) {
				NamedEntity value = mapElem.getValue();
				value.prettyPrint();
			}
			scanner.close();
		}
	}

	private static void setCategories(NamedEntity namedEntity) {

		// Persona
		Apellido.setApellidoCategory(namedEntity);
		Nombre.setNameCategory(namedEntity);
		Titulo.setTituloCategory(namedEntity);
		Pais.setPaisCategory(namedEntity);
		Ciudad.setCiudadCategory(namedEntity);
		Direccion.setDireccionCategory(namedEntity);
		Organizacion.setOrganizacionCategory(namedEntity);
		Producto.setProductoCategory(namedEntity);
		Evento.setEventoCategory(namedEntity);
		Fecha.setFechaCategory(namedEntity);
		if (namedEntity.getCategories().isEmpty()){
			Otro.setOtroCategory(namedEntity);
		}

		// Temas
		Basquet.setBasquetCategory(namedEntity);
		Cine.setCinemaCategory(namedEntity);
		Formula1.setFormula1Category(namedEntity);
		Futbol.setFutbolCategory(namedEntity);
		Internacional.setInternacionalCategory(namedEntity);
		Musica.setMusicaCategory(namedEntity);
		Nacional.setNacionalCategory(namedEntity);
		OtrosCultura.setOtrosCulturaCategory(namedEntity);
		OtrosDeportes.setOtrosDeportesCategory(namedEntity);
		Tenis.setTenisCategory(namedEntity);
	}
}
