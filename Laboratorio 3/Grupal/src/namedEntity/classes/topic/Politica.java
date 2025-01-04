package namedEntity.classes.topic;

import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Politica extends NamedEntity {

    static public int politica_frequency = 0;
    public Politica 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        politica_frequency++;
    }
    static public void incPoliticaFrequency(){
        politica_frequency++;
    }
    static public int getPoliticaFrequency(){
        return politica_frequency;
    }
}