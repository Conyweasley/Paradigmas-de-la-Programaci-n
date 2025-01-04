package httpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

/* Realiza el pedido de feed al servidor */

public class httpRequester implements Serializable {

    public String getFeedCommon(String urlFeed, String typeOfApplication) {
        String feedRssXml = null; // String XML

        try {
            URL url = new URL(urlFeed);
            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection(); // Crea la conexion

            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/" + typeOfApplication);
            con.setConnectTimeout(5000); // Tiempo limite de conexion o lectura
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            BufferedReader in = null; // Almacena el contenido de la respuesta

            if (status > 299) { // Casos de error
                in =
                        new BufferedReader(new InputStreamReader(con.getErrorStream()));
            } else {
                in =
                        new BufferedReader(new InputStreamReader(con.getInputStream()));
            }

            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            feedRssXml = content.toString();
            con.disconnect(); // Cierra la conexion

        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedRssXml;
    }

    public String getFeedRss(String urlFeed) {
        return getFeedCommon(urlFeed, "rss+xml");
    }

    public String feedRedditJson(String urlFeed) {
        return getFeedCommon(urlFeed, "json");
    }
}