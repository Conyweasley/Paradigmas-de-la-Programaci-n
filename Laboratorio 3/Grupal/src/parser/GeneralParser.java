package parser;

import subscription.SingleSubscription;
import subscription.Subscription;

import java.util.ArrayList;

/* Modela atributos y metodos comunes a todos los parser de la aplicacion */
public abstract class GeneralParser {
    protected String jsonPath = "config/subscriptions.json";
    protected Subscription sub = new Subscription(jsonPath);
    protected SingleSubscription sp =
            new SingleSubscription("", new ArrayList<>(), "");

    public SingleSubscription getEmptySingleSubscription() {
        return sp;
    }

    public Subscription getSubscription() {
        return sub;
    }

    public String getFilePath() {
        return jsonPath;
    }
}
