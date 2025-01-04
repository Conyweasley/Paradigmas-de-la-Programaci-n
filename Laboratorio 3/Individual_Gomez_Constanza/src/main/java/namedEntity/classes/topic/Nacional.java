package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Nacional extends Politica {

    public static ArrayList<String> data_national = Dictionaries.data_pltcs_argentina;

    public Nacional 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
    }

    public static void setNacionalCategory(NamedEntity ne){
        if (data_national.contains(ne.getName())) {
			ne.setCategory("Politica nacional");
		} 
    }
}