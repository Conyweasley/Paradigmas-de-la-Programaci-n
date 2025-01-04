package namedEntity;

import java.util.ArrayList;
import java.util.List;

/* Modela la nocion de entidad nombrada */
public class NamedEntity {

    private static int class_frequency;
    String name;
    ArrayList<String> categories;
    int frequency;

    public NamedEntity
            (String name, ArrayList<String> categories, int frequency) {
        super();
        this.name = name;
        this.categories = categories;
        this.frequency = frequency;
    }

    public static int getClassFrequency() {

        return class_frequency;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<String> getCategories() {

        return categories;
    }

    public void setCategory(String category) {

        this.categories.add(category);
    }

    public int getFrequency() {

        return frequency;
    }

    public void setFrequency(int frequency) {

        this.frequency = frequency;
    }

    public void incFrequency() {

        this.frequency++;
    }

    public void incClassFrequency() {

        class_frequency++;
    }

    @Override
    public String toString() {
        return "ObjectNamedEntity [name=" + name + ", frequency=" + frequency + ", categories= " + categories + "]";
    }

    public void prettyPrint() {
        System.out.println("Name: " + this.getName() + ", frequency: " + this.getFrequency() + ", categories: " + this.getCategories());
    }
}