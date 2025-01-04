package namedEntity.classes.namedEntityClasses;

import namedEntity.dictionaries.Dictionaries;
import namedEntity.NamedEntity;
import java.util.ArrayList;

public class Producto extends NamedEntity {

    private String comercial;
    private String productor;

    public static ArrayList<String> data_producto = Dictionaries.data_product;

    public Producto 
        (String comercial, String productor, String name, ArrayList<String> categories, int frequency) {
        super(name, categories, frequency);
        this.comercial = comercial;
        this.productor = productor;
    }

    public static void setProductoCategory(NamedEntity ne){
        if (data_producto.contains(ne.getName())) {
            ne.setCategory("Producto");
        } 
    }

    public String getComercial() {
		return comercial;
	}
    
    public String getPproductor() {
		return productor;
	}
}