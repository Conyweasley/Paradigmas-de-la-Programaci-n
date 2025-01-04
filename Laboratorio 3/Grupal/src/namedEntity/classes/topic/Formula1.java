package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Formula1 extends Deportes {

    static public int formula1Count = 0;
    public static ArrayList<String> data_f1 = Dictionaries.data_formula1;

    public Formula1 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        formula1Count++;
    }

    public static void setFormula1Category(NamedEntity ne){
        if (data_f1.contains(ne.getName())) {
			ne.setCategory("Formula 1");
		} 
    }

    static public int getFormula1Count(){
        return formula1Count;
    }
}