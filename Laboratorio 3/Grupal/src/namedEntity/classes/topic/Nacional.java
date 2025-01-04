package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Nacional extends Politica {

    static public int nacional_frequency = 0;
    public static ArrayList<String> data_national = Dictionaries.data_pltcs_argentina;

    public Nacional 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        nacional_frequency++;
    }

    public static void setNacionalCategory(NamedEntity ne){
        if (data_national.contains(ne.getName())) {
			ne.setCategory("Politica nacional");
		} 
    }

    public static int getNacionalFrequency() {
        return nacional_frequency;
    }
}