package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Fecha extends NamedEntity {

    private int precisa;
    private int canonica;
    
    public static ArrayList<String> data_fecha = Dictionaries.data_date;

    public Fecha 
        (int precisa, int canonica, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.canonica = canonica;
        this.precisa = precisa;
    }

    public static void setFechaCategory(NamedEntity ne){
        if(data_fecha.contains(ne.getName())){
            ne.setCategory("Fecha");
        } 
    }

    public int getCanonica() {
		return canonica;
	}

    public int getPrecisa() {
        return precisa;
    }
}