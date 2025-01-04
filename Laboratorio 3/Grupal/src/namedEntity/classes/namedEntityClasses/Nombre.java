package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Nombre extends Persona {

    public static ArrayList<String> data_nombre = Dictionaries.data_name;
    private static int nombre_frequency = 0;

    public Nombre 
        (int id, String name, ArrayList<String> categories, int frequency){
        super(id, name, categories, frequency);
        incFrequency();
        incPersonaFrequency();
        ++nombre_frequency;
    }

    public static void setNameCategory(NamedEntity ne){
        if(data_nombre.contains(ne.getName())){
			ne.setCategory("Nombre");
		} 
    }

    public static int getNombreFrequency(){
        return nombre_frequency;
    }
}