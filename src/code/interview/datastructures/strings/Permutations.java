package code.interview.datastructures.strings;

import java.util.Map;

public class Permutations {
	
	public static boolean arePermutations(String str1, String str2) {
		Map<Character, Integer> symbols1 = UniqueCharacters.getSymbolsMap(str1);
		Map<Character, Integer> symbols2 = UniqueCharacters.getSymbolsMap(str2);

		return symbols1.equals(symbols2);
	}

	
	public static void main(String[] args) {
		String str1 = "mamawer";
		String str2 = "amam";
		boolean permutations = arePermutations(str1, str2);
		
		if (permutations) {
			System.out.println("String '" + str2 + "' is a permutation of the string '" + str1 + "'");
		} else {
			System.out.println("String '" + str2 + "' is NOT a permutation of the string '" + str1 + "'");
		}
	}
}
