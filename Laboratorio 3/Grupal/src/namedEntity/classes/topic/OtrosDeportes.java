package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class OtrosDeportes extends Deportes {

    static public int otrosDeportesCount = 0;
    public static ArrayList<String> data_otherSports = Dictionaries.data_sport;

    public OtrosDeportes 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        otrosDeportesCount++;
    }

    public static void setOtrosDeportesCategory(NamedEntity ne){
        if (data_otherSports.contains(ne.getName())) {
			ne.setCategory("Otros Deportes");
		} 
    }

    static public int getOtrosDeportesCount(){
        return otrosDeportesCount;
    }
}