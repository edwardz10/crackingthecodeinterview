package mkyong.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachExample {

	public static void forEachMap() {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		items.forEach((k, v) -> {System.out.println("key: " + k + ", value: " + v);});
	}
	
	public static void forEachList() {
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		items.forEach(e -> {
				if (e.equals("C")) {
					System.out.println("Element: " + e);
				}
			});
	}
	
	public static void main(String[] args) {
		forEachMap();
		forEachList();
	}
}
