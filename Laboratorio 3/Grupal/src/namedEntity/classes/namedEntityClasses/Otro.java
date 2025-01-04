package namedEntity.classes.namedEntityClasses;

import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Otro extends NamedEntity {

    private String comentarios;
    static public int otro_frequency = 0;

    public Otro(String comentarios, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.comentarios = comentarios;
        incFrequency();
        ++otro_frequency;
    }

    public static void setOtroCategory(NamedEntity ne){
	    ne.setCategory("Otro NE"); // Solo llamarlo si hasta este punto su lista de categorias esta vacia
    }

    public String getComentarios() {
		return comentarios;
	}

    static public int getOtroFrequency() {
        return otro_frequency;
    }
}