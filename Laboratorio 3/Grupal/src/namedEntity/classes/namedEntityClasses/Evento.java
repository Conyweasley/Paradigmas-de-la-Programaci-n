package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Evento extends NamedEntity {

    private String canonica;
    private int fecha;
    private boolean recurrente;
    static public int event_frequency = 0;
    
    public static ArrayList<String> data_evento = Dictionaries.data_event;

    public Evento 
        (String canonica, int fecha, boolean recurrente, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.canonica = canonica;
        this.fecha = fecha;
        this.recurrente = recurrente;
        incFrequency();
        ++event_frequency;
    }

    public static void setEventoCategory(NamedEntity ne){
        if (data_evento.contains(ne.getName())) {
            ne.setCategory("Evento");
        } 
    }

    public String getCanonica() {
		return canonica;
	}

    public int getFecha() {
        return fecha;
    }

    public boolean getRecurrente() {
        return recurrente;
    }

    static public int getEventFrequency() {
        return event_frequency;
    }
}