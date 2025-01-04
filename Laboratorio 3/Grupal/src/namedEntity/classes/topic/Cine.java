package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Cine extends Cultura {

    static public int cine_frequency = 0;
    public static ArrayList<String> data_cinema = Dictionaries.data_cinema;

    public Cine 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        cine_frequency++;
    }

    public static void setCinemaCategory(NamedEntity ne){
        if (data_cinema.contains(ne.getName())) {
			ne.setCategory("Cine");
		} 
    }

    static public int getCineFrequency(){
        return cine_frequency;
    }
}