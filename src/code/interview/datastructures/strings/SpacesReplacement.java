package code.interview.datastructures.strings;

public class SpacesReplacement {

	private static int getCharacterCount(String str, char ch) {
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) count++;
		}
		
		return count;
	}
	
	public static String replaceSpaces(String str) {
		String trimmedString = str.trim();
		String replacement = "%20";
		int spacesCount = getCharacterCount(trimmedString, ' ');
		int length = trimmedString.length() - spacesCount + spacesCount*replacement.length();
		
		char[] characters = new char[length];

		for (int i = 0, j = 0; i < trimmedString.length(); i++) {
			char ch = trimmedString.charAt(i);
			
			if (ch == ' ') {
				for (int k = 0; k < replacement.length(); k++) {
					characters[j++] = replacement.charAt(k);
				}
			} else {
				characters[j++] = ch;
			}
		}
		
		return new String(characters);
	}
	
	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		System.out.println("Replaced spaces in string '" + str + "': '" + replaceSpaces(str) + "'");
	}
}
