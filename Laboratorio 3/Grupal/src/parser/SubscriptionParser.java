package parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import subscription.SingleSubscription;
import subscription.Subscription;

import java.io.FileReader;
import java.io.Reader;

/* Parser del  archivo de suscripcion (json) */
public class SubscriptionParser extends GeneralParser {


    public Subscription getFeedUrls(String urlTypeValue) {
        Subscription feedUrls = getSubscription();
        SingleSubscription sp = getEmptySingleSubscription();

        try {
            Reader reader = new FileReader(getFilePath());
            JsonArray jsonArray =
                    JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement elem : jsonArray) {
                JsonObject jsonObj = elem.getAsJsonObject();

                sp.setUrl(jsonObj.get("url").getAsString());
                sp.setUrlType(jsonObj.get("urlType").getAsString());

                JsonArray urlParamsArray =
                        jsonObj.get("urlParams").getAsJsonArray(); // Array de parametros

                for (JsonElement param : urlParamsArray) {
                    sp.setUlrParams(param.getAsString());
                }

                for (int i = 0; i < sp.getUlrParamsSize(); ++i) {
                    if (sp.getUrlType().equals(urlTypeValue)) {
                        feedUrls.addSingleSubscription(new SingleSubscription(sp.getFeedToRequest(i),
                                sp.getUlrParams(),
                                sp.getUrlType()));
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedUrls;
    }
}