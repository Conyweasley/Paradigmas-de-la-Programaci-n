package namedEntity.classes.namedEntityClasses;

import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Lugar extends NamedEntity {

    public static int lugar_frequency = 0;
    public Lugar (String name, ArrayList<String> categories, int frequency) {

        super(name, categories, frequency);
        incFrequency();
    }

    public static void incLugarFrequency(){
        ++lugar_frequency;
    }

    public static int getLugarFrequency(){
        return lugar_frequency;
    }
}