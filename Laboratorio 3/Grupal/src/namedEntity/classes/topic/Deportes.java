package namedEntity.classes.topic;

import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Deportes extends NamedEntity {

    static public int deportes_frequency = 0;
    public Deportes 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        deportes_frequency++;
    }
    static public void incDeportesFrequency(){
        deportes_frequency++;
    }
    static public int getDeportesFrequency(){
        return deportes_frequency;
    }
}