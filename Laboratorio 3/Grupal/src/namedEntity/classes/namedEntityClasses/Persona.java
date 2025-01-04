package namedEntity.classes.namedEntityClasses;

import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Persona extends NamedEntity {
    private int id;
    private static int persona_frequency = 0;

    public Persona 
        (int id, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static int getPersonaFrequency(){
        return persona_frequency;
    }

    public static void incPersonaFrequency(){
        ++persona_frequency;
    }
}