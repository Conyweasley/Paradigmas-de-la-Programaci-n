package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Titulo extends Persona {

    public static ArrayList<String> data_titulo = Dictionaries.data_degree;

    public static int titulo_frequency = 0;

    public Titulo 
        (int id, String name, ArrayList<String> categories, int frequency) {
        super(id, name, categories, frequency);
        incFrequency();
        incPersonaFrequency();
        ++titulo_frequency;
    }

    public static void setTituloCategory(NamedEntity ne){
        if (data_titulo.contains(ne.getName())){
			ne.setCategory("Titulo");
		} 
    }

    public static int getTituloFrequency(){
        return titulo_frequency;
    }
}