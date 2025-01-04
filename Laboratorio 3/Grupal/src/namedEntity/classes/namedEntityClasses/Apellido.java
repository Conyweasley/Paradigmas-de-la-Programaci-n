package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Apellido extends Persona {

    public static ArrayList<String> data_apellido = Dictionaries.data_surname;
    private static int apellido_frequency = 0;

    public Apellido 
        (int id, String name, ArrayList<String> categories, int frequency) {
        super(id, name, categories, frequency);
        incFrequency();
        incPersonaFrequency();
        ++apellido_frequency;
    }

    public static void setApellidoCategory(NamedEntity ne){
        if (data_apellido.contains(ne.getName())) {
			ne.setCategory("Apellido");
		} 
    }

    public static int getApellidoFrequency(){
        return apellido_frequency;
    }
}