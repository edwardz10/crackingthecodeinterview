package hackerrank.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FunnyString {

    static String funnyString(String s) {
    	//System.out.println("Length: " + s.length());
        boolean isFunny = true;
        int diff = 0, reverseDiff = 0;
        int ch1, ch2, ch3, ch4;
        
        for (int i = 0; i < s.length()/2; i++) {
        	ch1 = s.charAt(i + 1);
        	ch2 = s.charAt(i);
        	ch3 = s.charAt(s.length() - i - 1);
        	ch4 = s.charAt(s.length() - i - 2);
        	
            diff = (int)(s.charAt(i + 1) - s.charAt(i));
            reverseDiff = (int)(s.charAt(s.length() - i - 2) - s.charAt(s.length() - i - 1));
//            System.out.println("ch1=" + ch1 + ", ch2=" + ch2 + ",ch3=" + ch3 + ",ch4=" + ch4);
//            System.out.println("i=" + i + ", diff=" + diff + ", reverseDiff=" + reverseDiff);
            
            if (Math.abs(reverseDiff) != Math.abs(diff)) {
                isFunny = false;
                break;
            }
        }
            
        return isFunny ? "Funny" : "Not Funny";
    }
	
	public static void main(String[] args) {
		String fileName = "c:\\work\\hackerrank\\FunnyString.txt";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
			String line = br.readLine();
			Integer numLines = Integer.parseInt(line);
			System.out.println(line);
			
			for (int i = 0; i < numLines; i++) {
				line = br.readLine();
				System.out.println(funnyString(line));
			}
		} catch (Exception ioe) {
			System.err.println("Failed to read file " + fileName + ": " + ioe.getMessage());
		}
	}
}
