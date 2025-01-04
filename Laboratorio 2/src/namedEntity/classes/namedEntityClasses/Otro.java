package namedEntity.classes.namedEntityClasses;

import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Otro extends NamedEntity {

    private String comentarios;

    public Otro(String comentarios, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.comentarios = comentarios;
    }

    public static void setOtroCategory(NamedEntity ne){
	    ne.setCategory("Otro"); // Solo llamarlo si hasta este punto su lista de categorias esta vacia
    }

    public String getComentarios() {
		return comentarios;
	}
}