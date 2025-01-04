package namedEntity.classes.topic;

import namedEntity.NamedEntity;

import java.util.ArrayList;

public class OtrosTopic extends NamedEntity {

    static public int otros_topic_frequency = 0;

    public OtrosTopic
            (String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        incFrequency();
        otros_topic_frequency++;
    }

    public static void setOtrosTopicCategory(NamedEntity ne){
        ne.setCategory("Otros Topic"); // Solo llamarlo si hasta este punto su lista de categorias topic esta vacia
    }

    static public int getOtrosTopicFrequency(){
        return otros_topic_frequency;
    }
}
