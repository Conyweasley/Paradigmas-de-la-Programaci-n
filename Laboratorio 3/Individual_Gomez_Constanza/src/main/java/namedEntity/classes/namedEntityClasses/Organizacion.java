package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Organizacion extends NamedEntity {
    
    private String canonica;
    private int miembros;
    private String tipo;

    public static ArrayList<String> data_org = Dictionaries.data_company;

    public Organizacion 
        (String canonica, int miembros, String tipo, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.canonica = canonica;
        this.miembros = miembros;
        this.tipo = tipo;
    }

    public static void setOrganizacionCategory(NamedEntity ne){
        if(data_org.contains(ne.getName())){
			ne.setCategory("Organizacion");
		} 
    }

    public String getCanonica() {
		return canonica;
	}

    public int getMiembros() {
		return miembros;
	}
    
    public String getTipo() {
		return tipo;
	}
}