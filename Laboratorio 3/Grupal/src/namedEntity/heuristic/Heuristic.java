package namedEntity.heuristic;

import java.util.HashMap;
import java.util.Map;

public abstract class Heuristic {

	private static final Map<String, String> categoryMap = createCategoryMap();

	private static Map<String, String> createCategoryMap() {
		Map<String, String> map = new HashMap<>();
		map.put("Microsoft", "Company");
		map.put("Apple", "Company");
		map.put("Google", "Company");
		map.put("Musk", "Person");
		map.put("Biden", "Person");
		map.put("Trump", "Person");
		map.put("Messi", "Person");
		map.put("Federer", "Person");
		map.put("USA", "Country");
		map.put("Russia", "Country");
		return map;
	}

	public String getCategory(String entity){
		return categoryMap.get(entity);
	}
	
	public abstract boolean isEntity(String word);
}