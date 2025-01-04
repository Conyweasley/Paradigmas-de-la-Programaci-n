package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class OtrosDireccion extends Lugar {

    public static ArrayList<String> data_direccion = Dictionaries.data_place_other;
    public static int otros_direccion_frequency = 0;

    public OtrosDireccion 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        incLugarFrequency();
        ++otros_direccion_frequency;
    }

    public static void setOtrosDireccionesCategory(NamedEntity ne){
        if(data_direccion.contains(ne.getName())) {
            ne.setCategory("Otros Direccion");
		} 
    }

    public static int getOtrosDireccionFrequency(){
        return otros_direccion_frequency;
    }
}
