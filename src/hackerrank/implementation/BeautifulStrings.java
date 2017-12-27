package hackerrank.implementation;

import java.math.BigDecimal;
import java.util.Scanner;

public class BeautifulStrings {

	static int getWidth(BigDecimal n) {
        return n.toString().length();
    }
	    
    static void defineIfBeautiful(String s) {
    	boolean beautiful = true;
    	
    	if (s.startsWith("0") || s.length() == 1) {
    		System.out.println("NO");
    		return;
    	}
   	
        for (int startWidth = 1; startWidth < s.length() + 1; startWidth++) {
        	beautiful = true;
        	int pos = 0;
            int width = startWidth;
            BigDecimal currentNumber = new BigDecimal(s.substring(pos, width));
            BigDecimal startNumber = currentNumber;
            BigDecimal nextNumberExpected = null, nextNumberActual = null;
            
	        while (true) {
	            nextNumberExpected = currentNumber.add(BigDecimal.ONE);
	            pos += width;
	            width = getWidth(nextNumberExpected);
                
	            if (pos + width > s.length()) {
	                beautiful = false;
	                break;
	            }
	
	            nextNumberActual = new BigDecimal(s.substring(pos, pos + width));
	
	            if (nextNumberActual.equals(nextNumberExpected)) {
	                currentNumber = nextNumberActual;
	            } else {
	                beautiful = false;
	                break;
	            }
	
	            if (pos + width == s.length()) {
	                break;
	            }
	        }
	        
	        if (beautiful) {
	        	System.out.println("YES " + startNumber);
	        	break;
	        } else {
                continue;
            }
        }

        if (!beautiful) {
        	System.out.println("NO");
        }
    }
	    
    public static void main(String[] args) {
//    	String[] numbers = {"1234", "91011", "99100", "101103", "010203", "13", "1"};

    	String[] numbers = {"00000000000000000000000000000000",
    	"11111111111111111111111111111111",
    	"22222222222222222222222222222222",
    	"33333333333333333333333333333333",
    	"44444444444444444444444444444444",
    	"55555555555555555555555555555555",
    	"66666666666666666666666666666666",
    	"77777777777777777777777777777777",
    	"88888888888888888888888888888888",
    	"10001001100210031004100510061007"};
    	
    	for (String s : numbers) {
    		defineIfBeautiful(s);
    	}
//    	defineIfBeautiful("91011");
    }		
}
