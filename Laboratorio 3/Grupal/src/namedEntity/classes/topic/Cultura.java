package namedEntity.classes.topic;

import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Cultura extends NamedEntity {

    static public int cultura_frequency = 0;
    public Cultura 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        cultura_frequency++;
    }
    static public void incCulturaFrequency(){
        cultura_frequency++;
    }
    static public int getCulturaFrequency(){
        return cultura_frequency;
    }
}