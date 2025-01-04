package parser;

import feed.Article;
import feed.Feed;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.Serializable;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Parser de feed de tipo rss (xml) */
public class RssParser extends GeneralParser implements Serializable {

    public static List<Date> getGenericDate(Document doc, String typeOfGet) {
        List<Date> dateList = new ArrayList<>();

        NodeList nList = doc.getElementsByTagName(typeOfGet);
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");

        for (int i = 0; i < nList.getLength(); ++i) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String dateString = eElement.getTextContent();

                try {
                    Date date = dateFormat.parse(dateString);
                    dateList.add(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return dateList;
    }

    public List<Article> parserForRss(String responseXML) {

        Feed f = new Feed("HttpRequester");

        try {
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc =
                    builder.parse(new InputSource(new StringReader(responseXML)));
            doc.getDocumentElement().normalize();

            List<String> listOfTitle = getData(doc, "title");
            List<String> listOfDescription = getData(doc, "description");
            List<String> listOfLink = getData(doc, "link");
            List<Date> listOfDate = getGenericDate(doc, "pubDate");

            for (int i = 0; i < listOfDescription.size(); ++i) {
                f.addArticle(new Article(listOfTitle.get(i),
                        listOfDescription.get(i),
                        listOfDate.get(i),
                        listOfLink.get(i)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f.getArticleList();
    }

    public List<String> getData(Document doc, String typeOfGet) {
        List<String> list = new ArrayList<String>();

        NodeList nList = doc.getElementsByTagName(typeOfGet);
        for (int i = 0; i < nList.getLength(); ++i) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                list.add(eElement.getTextContent());
            }
        }
        return list;
    }
}