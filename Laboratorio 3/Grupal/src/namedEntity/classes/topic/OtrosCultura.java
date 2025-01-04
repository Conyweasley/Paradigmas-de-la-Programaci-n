package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class OtrosCultura extends Cultura {

    static public int otrosCultura_frequency = 0;
    public static ArrayList<String> data_otherCulture = Dictionaries.data_culture;

    public OtrosCultura 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        otrosCultura_frequency++;
    }

    public static void setOtrosCulturaCategory(NamedEntity ne){
        if (data_otherCulture.contains(ne.getName())) {
			ne.setCategory("Otros Cultura");
		} 
    }
    static public int getOtrosCulturaFrequency(){
        return otrosCultura_frequency;
    }
}