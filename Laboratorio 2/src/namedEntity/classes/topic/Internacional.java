package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Internacional extends Politica {

    public static ArrayList<String> data_pltcs_int = Dictionaries.data_pltcs_international;

    public Internacional 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
    }

    public static void setInternacionalCategory(NamedEntity ne){
        if (data_pltcs_int.contains(ne.getName())) {
			ne.setCategory("Politica Internacional");
		} 
    }
}