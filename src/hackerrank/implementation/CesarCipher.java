package hackerrank.implementation;

public class CesarCipher {

    static int getShiftedChar(int src, int shifts, int left, int right) {
    	int normalizedShift = shifts;
    	
    	if (normalizedShift > 26) {
    		normalizedShift = normalizedShift % 26;
    	}
    	
        int result = src + normalizedShift;

        if (result > right) {
            result = left + normalizedShift - (right - src) - 1;
        } 
        
        return result;
    }
    
    static String getCipheredString(String s, int shifts) {
        StringBuilder sb = new StringBuilder();
        int asciiSrc = 0, asciiDest = 0;
        
        for (int i = 0; i < s.length(); i++) {
            asciiSrc = (int)s.charAt(i);

            if (asciiSrc >= 65 && asciiSrc <= 90) {
                asciiDest = getShiftedChar(asciiSrc, shifts, 65, 90);
                sb.append((char)asciiDest);
            } else if (asciiSrc >= 97 && asciiSrc <= 122) {
                asciiDest = getShiftedChar(asciiSrc, shifts, 97, 122);
                sb.append((char)asciiDest);
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(getCipheredString("Pz-/aI/J`EvfthGH", 66));
	}
}
