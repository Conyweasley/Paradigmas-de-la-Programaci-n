package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Apellido extends Persona {

    public static ArrayList<String> data_apellido = Dictionaries.data_surname;

    public Apellido 
        (int id, String name, ArrayList<String> categories, int frequency) {
        super(id, name, categories, frequency);
    }

    public static void setApellidoCategory(NamedEntity ne){
        if (data_apellido.contains(ne.getName())) {
			ne.setCategory("Apellido");
		} 
    }
}