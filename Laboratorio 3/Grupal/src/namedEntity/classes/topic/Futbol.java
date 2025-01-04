package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Futbol extends Deportes {

    static public int futbolCount = 0;
    public static ArrayList<String> data_futbol = Dictionaries.data_football;

    public Futbol 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        futbolCount++;
    }

    public static void setFutbolCategory(NamedEntity ne){
        if (data_futbol.contains(ne.getName())) {
			ne.setCategory("Futbol");
		} 
    }
    static public int getFutbolCount(){
        return futbolCount;
    }
}