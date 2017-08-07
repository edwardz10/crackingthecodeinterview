package code.interview.datastructures.strings;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacters {

	public static boolean hasUniqueSymbols(Map<Character, Integer> symbols) {
		for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
			if (entry.getValue() > 1) return false;
		}
		
		return true;
	}

	public static Map<Character, Integer> getSymbolsMap(String str) {
		Map<Character, Integer> symbols = new HashMap<>();
		Character c = null; 
		
		for (int i = 0; i < str.length(); i++) {
			c = Character.toLowerCase(str.charAt(i));

			Integer number = symbols.get(c);

			if (number == null) {
				symbols.put(c, 1);
			} else {
				symbols.remove(c);
				symbols.put(c, number + 1);
			}
		}

		return symbols;
	}
	
	public static boolean hasUniqueSymbols(String str) {
		Map<Character, Integer> symbols = getSymbolsMap(str);
		System.out.println("Symbols of string '" + str + "': " + symbols);
		
		return hasUniqueSymbols(symbols);
	}
	
	public static void main(String[] args) {
		String str = "Abracadabra";
		boolean hasUniqueChars = hasUniqueSymbols(str);

		if (hasUniqueChars) {
			System.out.println("String '" + str + "' has unique characters");
		} else {
			System.out.println("String '" + str + "' doesn't have unique characters");
		}
	}
}

