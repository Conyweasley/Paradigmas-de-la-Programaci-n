package namedEntity.classes;

import namedEntity.FrequencyClasses;
import namedEntity.NamedEntity;
import namedEntity.classes.namedEntityClasses.*;
import namedEntity.classes.topic.*;

public class Classes {

    public static void setCategories(NamedEntity namedEntity) {

        // Persona
        Apellido.setApellidoCategory(namedEntity);
        Nombre.setNameCategory(namedEntity);
        Titulo.setTituloCategory(namedEntity);
        Pais.setPaisCategory(namedEntity);
        Ciudad.setCiudadCategory(namedEntity);
        Direccion.setDireccionCategory(namedEntity);
        Organizacion.setOrganizacionCategory(namedEntity);
        Producto.setProductoCategory(namedEntity);
        Evento.setEventoCategory(namedEntity);
        Fecha.setFechaCategory(namedEntity);
        if (namedEntity.getCategories().isEmpty()){
            Otro.setOtroCategory(namedEntity);
        }

        // Temas
        Basquet.setBasquetCategory(namedEntity);
        Cine.setCinemaCategory(namedEntity);
        Formula1.setFormula1Category(namedEntity);
        Futbol.setFutbolCategory(namedEntity);
        Internacional.setInternacionalCategory(namedEntity);
        Musica.setMusicaCategory(namedEntity);
        Nacional.setNacionalCategory(namedEntity);
        OtrosCultura.setOtrosCulturaCategory(namedEntity);
        OtrosDeportes.setOtrosDeportesCategory(namedEntity);
        Tenis.setTenisCategory(namedEntity);
        if (namedEntity.getCategories().isEmpty()){
            OtrosTopic.setOtrosTopicCategory(namedEntity);
        }
    }

    public static String getParentCategory(String category) {
        switch (category) {
            case "Apellido":
            case "Nombre":
            case "Titulo":
                return "Persona";
            case "Pais":
            case "Ciudad":
            case "Direccion":
                return "Lugar";
            case "Organizacion":
            case "Producto":
            case "Evento":
            case "Fecha":
            case "Otro NE":
            case "Persona":
            case "Lugar":
                return "Entidad nombrada";

            case "Basquet":
            case "Tenis":
            case "Futbol":
            case "Formula 1":
            case "Otros Deportes":
                return "Deportes";
            case "Cine":
            case "Musica":
            case "Otros Cultura":
                return "Cultura";
            case "Internacional":
            case "Nacional":
                return "Politica";
            case "Otro Topic":
            case "Deportes":
            case "Cultura":
            case "Politica":
                return "Tema";

            default:
                return null;
        }
    }

    public static void printClasses() {

        for (String category : FrequencyClasses.categories) {
            System.out.println(category + ": " + FrequencyClasses.getFrequency(category));
        }
    }
}