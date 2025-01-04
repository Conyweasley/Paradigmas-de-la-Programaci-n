package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Musica extends Cultura {

    static public int musica_frequency = 0;

    public static ArrayList<String> data_music = Dictionaries.data_music;

    public Musica 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        musica_frequency++;
    }

    public static void setMusicaCategory(NamedEntity ne){
        if (data_music.contains(ne.getName())) {
			ne.setCategory("Musica");
		} 
    }

    static public int getMusicaFrequency(){
        return musica_frequency;
    }
}