package code.interview.datastructures.strings;

import java.util.Arrays;

public class SubstringChecker {

	public static boolean isSubstring(String str1, String str2) {
		if (str1.equals(str2)) 
			return true;
		
		String longest, shortest;

		if (str1.length() > str2.length()) {
			longest = str1;
			shortest = str2;
		} else {
			longest = str2;
			shortest = str1;
		}

		for (int i = 0; i <= longest.length() - shortest.length(); i++) {
			if (longest.substring(i, i + shortest.length()).equals(shortest)) 
				return true;
		}

		return false;
	} 

	public static String getSortedString(String str) {
		char[] str1Array = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			str1Array[i] = str.charAt(i);
		}
		
		Arrays.sort(str1Array);

		return new String(str1Array);
	}
	
	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "erbottlewat";

		if (isSubstring(str1, str2)) {
			System.out.println("Substring");
		} else {
			System.out.println("NOT Substring");
		}

		String str1Sorted = getSortedString(str1);
		String str2Sorted = getSortedString(str2);
		
		if (isSubstring(str1Sorted, str2Sorted)) {
			System.out.println("Substring");
		} else {
			System.out.println("NOT Substring");
		}
	}
}
