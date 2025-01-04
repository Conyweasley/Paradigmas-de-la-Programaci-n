package namedEntity.classes.topic;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Musica extends Cultura {

    public static ArrayList<String> data_music = Dictionaries.data_music;

    public Musica 
        (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
    }

    public static void setMusicaCategory(NamedEntity ne){
        if (data_music.contains(ne.getName())) {
			ne.setCategory("Musica");
		} 
    }
}