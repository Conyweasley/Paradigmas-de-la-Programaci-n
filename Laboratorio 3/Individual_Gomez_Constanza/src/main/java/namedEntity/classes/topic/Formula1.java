package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Formula1 extends Deportes {

    public static ArrayList<String> data_f1 = Dictionaries.data_formula1;

    public Formula1 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
    }

    public static void setFormula1Category(NamedEntity ne){
        if (data_f1.contains(ne.getName())) {
			ne.setCategory("Formula 1");
		} 
    }
}