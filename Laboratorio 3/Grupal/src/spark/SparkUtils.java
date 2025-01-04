package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkUtils {

    private static JavaSparkContext sparkContext; // Unica instancia de JavaSparkContext para toda la aplicacion

    private SparkUtils() {
        // Constructor privado para evitar la creacion de nuevas instancias
    }

    // Crea el contexto de Spark si no existe (solo una instancia a la vez)
    public static void createSparkContext() { 
        if (sparkContext == null) {
            SparkConf sparkConf = new SparkConf()
                    .setAppName("FeedReader")
                    .setMaster("local[*]")
                    .set("spark.driver.extraJavaOptions", "-Dlog4j.configuration=file:spark/log4j.properties");
            sparkContext = new JavaSparkContext(sparkConf);
        }
    }

    // Para el contexto de Spark si existe
    public static void stopSparkContext() {
        if (sparkContext != null) {
            sparkContext.stop();
            sparkContext = null;
        }
    }

    // Devuelve el contexto de Spark si existe, si no lo crea
    public static JavaSparkContext getSparkContext() {

        return sparkContext;
    }
}
