package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Basquet extends Deportes {

    static public int basquetCount = 0;
    public static ArrayList<String> data_basquet = Dictionaries.data_basquetball;

    public Basquet 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        basquetCount++;
    }

    public static void setBasquetCategory(NamedEntity ne){
        if (data_basquet.contains(ne.getName())) {
			ne.setCategory("Basquet");
		} 
    }

    public static int getBasquetCount(){
        return basquetCount;
    }
}