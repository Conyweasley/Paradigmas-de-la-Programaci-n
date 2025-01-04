package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Tenis extends Deportes {

    public static ArrayList<String> data_tenis = Dictionaries.data_tenis;

    public Tenis 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
    }

    public static void setTenisCategory(NamedEntity ne){
        if (data_tenis.contains(ne.getName())) {
			ne.setCategory("Tenis");
		} 
    }
}