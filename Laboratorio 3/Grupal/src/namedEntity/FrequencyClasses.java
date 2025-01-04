package namedEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static namedEntity.classes.Classes.getParentCategory;

public class FrequencyClasses {

    static public String[] categories = {"Entidad nombrada", "Persona", "Apellido", "Nombre", "Titulo",
            "Lugar", "Pais", "Ciudad", "Direccion", "Otros Direccion", "Organizacion",
            "Producto", "Evento", "Fecha", "Tema", "Politica",
            "Nacional", "Internacional", "Cultura", "Cine", "Musica", "Otros Cultura",
            "Deportes", "Basquet", "Tenis", "Futbol", "Formula 1", "Otros Deportes",
            "Otro Topic", "Otro NE"};
    static private Map<String, Integer> classFrequencyMap = new HashMap<>();

    public FrequencyClasses() {
        classFrequencyMap = new HashMap<>();
        for (String category : categories) {
            classFrequencyMap.put(category, 0);
        }
    }

    static public void incrementFrequency(List<String> categories) {
        for (String category : categories) {
            int currentFrequency = classFrequencyMap.getOrDefault(category, 0);
            classFrequencyMap.put(category, currentFrequency + 1);

            String parentCategory = getParentCategory(category);
            while (parentCategory != null) {
                int parentFrequency = classFrequencyMap.getOrDefault(parentCategory, 0);
                classFrequencyMap.put(parentCategory, parentFrequency + 1);
                parentCategory = getParentCategory(parentCategory);
            }
        }
    }


    static public int getFrequency(String category) {
        return classFrequencyMap.getOrDefault(category, 0);
    }

}