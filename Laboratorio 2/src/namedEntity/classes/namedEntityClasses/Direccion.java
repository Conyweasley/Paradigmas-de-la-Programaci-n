package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Direccion extends Lugar {

    private String ciudad;

    public static ArrayList<String> data_direccion = Dictionaries.data_address;

    public Direccion 
        (String ciudad, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.ciudad = ciudad;
    }

    public static void setDireccionCategory(NamedEntity ne){
        if (data_direccion.contains(ne.getName())) {
            ne.setCategory("Direccion");
		} 
    }
    public String getCiudad() {
        return ciudad;
    }
}