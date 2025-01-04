package namedEntity.classes.namedEntityClasses;

import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Persona extends NamedEntity {
    private int id;

    public Persona 
        (int id, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}