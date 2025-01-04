package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Titulo extends Persona {

    public static ArrayList<String> data_titulo = Dictionaries.data_degree;

    public Titulo 
        (int id, String name, ArrayList<String> categories, int frequency) {
        super(id, name, categories, frequency);
    }

    public static void setTituloCategory(NamedEntity ne){
        if (data_titulo.contains(ne.getName())){
			ne.setCategory("Titulo");
		} 
    }
}