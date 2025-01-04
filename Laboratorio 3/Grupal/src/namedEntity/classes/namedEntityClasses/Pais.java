package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Pais extends Lugar {

    private int poblacion;
    private String lenguaOficial;

    public static int pais_frequency = 0;

    public static ArrayList<String> data_pais = Dictionaries.data_country;

    public Pais 
		(int poblacion, String lenguaOficial, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.poblacion = poblacion;
        this.lenguaOficial = lenguaOficial;
        incFrequency();
        incLugarFrequency();
        ++pais_frequency;
    }

    public static void setPaisCategory(NamedEntity ne){
        if(data_pais.contains(ne.getName())){
			ne.setCategory("Pais");
		} 
    }
    
    public int getPoblacion() {
		return poblacion;
	}

    public String getLenguaOficial() {
		return lenguaOficial;
	}

    public static int getPaisFrequency(){
        return pais_frequency;
    }
}
