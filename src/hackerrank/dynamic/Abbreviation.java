package hackerrank.dynamic;

public class Abbreviation {

	static boolean containsUpperCaseBetween(String s, int start, int end, char c) {
        for (int i = start; i < end; i++) {
            if (Character.isUpperCase(s.charAt(i)) && Character.toLowerCase(s.charAt(i)) != c) {
//            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }
        }
        
        return false;
    }

    static int indexOfIgnoreCase(String s, char c, int position) {
        for (int i = position; i < s.length(); i++) {
            if (s.charAt(i) == c || Character.toUpperCase(s.charAt(i)) == c)
                return i;
        }
        
        return -1;
    }                
                
    static String abbreviation(String a, String b) {
        boolean correct = true;
        //b = b.toLowerCase();
        int pos = indexOfIgnoreCase(a, b.charAt(0), 0);

        if (pos == -1) {
            correct = false;
            System.out.println("string a doesn't contain the first letter of b: '" + b.charAt(0) + "'");
        } else {
            int bLetterPositionInA = 0;

            for (int i = 1; i < b.length(); i++) {
                System.out.println("letter from b: '" + b.charAt(i) + "'");
                bLetterPositionInA = indexOfIgnoreCase(a, b.charAt(i), pos + 1);

                if (bLetterPositionInA != -1) {
                    if (containsUpperCaseBetween(a, pos + 1, bLetterPositionInA - 1, b.charAt(i))) {
                        System.out.println("string a contains uppercase letters between " + pos + " and " + bLetterPositionInA);
                        correct = false;    
                        break;
                    } else {
                        pos = bLetterPositionInA;
                    }
                } else {
                    correct = false;
                    System.out.println("string a doesn't contain letter of b: '" + b.charAt(i) + "'");
                    break;
                }

            }

            if (correct) {
            	if (containsUpperCaseBetween(a, pos + 1, a.length() - 1, ' ')) {
            		System.out.println("There are uppercase letter in string a after string b");
            		correct = false;
            	}
            }
        }
        
        return correct ? "YES" : "NO";
    }
	
	public static void main(String[] args) {
		System.out.println(abbreviation("EOWZEOHWYOJTBNMcefdsp",
										"EOWZEOHWYOJTBNM"));
	}
}
