package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Ciudad extends Lugar {

    private String pais;
    private String capital;
    private int poblacion;
    public static int ciudad_frequency = 0;
    
    public static ArrayList<String> data_ciudad = Dictionaries.data_city;

    public Ciudad 
        (String pais, String capital, int poblacion, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.pais = pais;
        this.capital = capital;
        this.poblacion = poblacion;
        incFrequency();
        incLugarFrequency();
        ++ciudad_frequency;
    }

    public static void setCiudadCategory(NamedEntity ne){
        if (data_ciudad.contains(ne.getName())) {
            ne.setCategory("Ciudad");
		} 
    }
    public String getPais() {
        return pais;
    }

    public String getCapital() {
        return capital;
    }

    public int getPoblacion() {
		return poblacion;
	}

    public static int getCiudadFrequency(){
        return ciudad_frequency;
    }
}