package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Direccion extends Lugar {

    private String ciudad;
    static int direccion_frequency = 0;

    public static ArrayList<String> data_direccion = Dictionaries.data_address;

    public Direccion 
        (String ciudad, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.ciudad = ciudad;
        incFrequency();
        incLugarFrequency();
        ++direccion_frequency;
    }

    public static void setDireccionCategory(NamedEntity ne){
        if (data_direccion.contains(ne.getName())) {
            ne.setCategory("Direccion");
		} 
    }
    public String getCiudad() {
        return ciudad;
    }

    static public int getDireccionFrequency(){
        return direccion_frequency;
    }
}