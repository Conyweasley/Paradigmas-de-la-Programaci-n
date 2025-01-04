package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Cine extends Cultura {

    public static ArrayList<String> data_cinema = Dictionaries.data_cinema;

    public Cine 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
    }

    public static void setCinemaCategory(NamedEntity ne){
        if (data_cinema.contains(ne.getName())) {
			ne.setCategory("Cine");
		} 
    }
}