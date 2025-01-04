import parser.*;
import httpRequest.httpRequester;

import feed.Article;
import feed.Feed;
import subscription.SingleSubscription;
import subscription.Subscription;
import namedEntity.heuristic.Heuristic;
import namedEntity.heuristic.QuickHeuristic;
import namedEntity.heuristic.RandomHeuristic;
import namedEntity.NamedEntity;

import java.util.Scanner;
import java.util.ArrayList;
import namedEntity.classes.namedEntityClasses.*;
import namedEntity.classes.topic.*;
import java.util.Map;
import java.util.HashMap;

public class FeedReaderMain {

	private static void printHelp(){
		System.out.println("Please, call this program in correct way: FeedReader [-ne]");
	}
	
	public static void main(String[] args) {
		System.out.println("************* FeedReader version 1.0 *************");
		// Instancias
		SubscriptionParser parser = new SubscriptionParser();
		RssParser rssParser = new RssParser();
		httpRequester hr = new httpRequester();
		Map<String, NamedEntity> namedEntityMap = new HashMap<>();

		// Lista de suscripciones
		Subscription listOfRSS = parser.getFeedUrls("rss");

		if (args.length == 0) {
			Feed f = new Feed("Titulo!");
			for (SingleSubscription subscriptionElem : listOfRSS.getSubscriptionsList()) {
				String responseXML = hr.getFeedRss(subscriptionElem.getUrl());
				f.setArticleList(rssParser.parserForRss(responseXML));
				f.prettyPrint();
			}

		} else if (args.length == 1) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("CHOICE THE HEURISTIC\n1) QUICK HEURISTIC\n2) RANDOM HEURISTIC");
			int option = scanner.nextInt();
			Heuristic heuristic = null; 
			Feed f = new Feed("Heuristica");
			
			if(option == 1) { 
				heuristic = new QuickHeuristic();

			} else if (option == 2) {
				heuristic = new RandomHeuristic();
			} 
			
			for (SingleSubscription subscriptionElem : listOfRSS.getSubscriptionsList()) {
				String responseXML = hr.getFeedRss(subscriptionElem.getUrl());
				f.setArticleList(rssParser.parserForRss(responseXML));

				for (Article art : f.getArticleList()) {
					for (String a : art.getText().split(" ")) {
						if (heuristic.isEntity(a)) {
							if (namedEntityMap.containsKey(a)) {
								// Recupero el namedEntity ya registrado
								NamedEntity namedEntity = namedEntityMap.get(a); 
								namedEntity.incFrequency();
							} else {
								// Creo un nuevo namedEntity
								NamedEntity namedEntity = 
									new NamedEntity(a, new ArrayList<>(), 1);
								setCategories(namedEntity);
								namedEntityMap.put(a, namedEntity);
							}
						}
					}
				}			
			}
				
			for (Map.Entry<String, NamedEntity> mapElem : namedEntityMap.entrySet()) {
				NamedEntity value = mapElem.getValue();
				value.prettyPrint();
			}
			scanner.close();
		}
		else {
			printHelp();
		}
	}

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
	}
}