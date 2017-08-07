package code.interview.datastructures.strings;

public class IsStringRotation {

	public static boolean isSubstring(String str1, String str2) {
		return str2.indexOf(str1) != -1;
	}
	
	public static boolean isStringRotation(String str1, String str2) {
		boolean result = true;
		String s;

		for (int i = 1; i < str1.length(); i++) {
			s = str1.substring(0, i);
			
			if (!isSubstring(s, str2)) {
				s = str1.substring(i);
				
				result = isSubstring(s, str2);
				break;
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		String str1 = "simpsons", str2 = "sonssimp";
		
		System.out.println((isStringRotation(str1, str2) 
				? "strings are rotations"
				: "strings are not rotations"));
	}
}
