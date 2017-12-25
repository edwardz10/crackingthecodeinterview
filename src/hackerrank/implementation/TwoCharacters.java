package hackerrank.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoCharacters {

    static String replaceCharacter(String s, Character c1, Character c2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c1 || s.charAt(i) == c2) sb.append(s.charAt(i));
        }
        
        return sb.toString();
    } 
    
    static boolean isValid(String s) {
        int character = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == character) return false;
            character = s.charAt(i);
        }
        
        return true;
    }

    static Set<Character> getUniqueCharacters(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) uniqueChars.add(s.charAt(i));
        
        return uniqueChars;
    }
    
    static void printLongestStringAfterReduction(String s) {
        int max = 0;
        Set<Character> uniqueChars = getUniqueCharacters(s);
        System.out.println("Unique chars: " + uniqueChars);
        List<Character> list = new ArrayList<Character>(uniqueChars);
        String replacedString = null;
        
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                //charsToLeave = new HashSet<>();
                //charsToLeave.add(list.get(i));
                //charsToLeave.add(list.get(j));
                System.out.println("Combination: " + list.get(i) + "-" + list.get(j));
                replacedString = replaceCharacter(s, list.get(i), list.get(j));
                System.out.println("Replaced string" + replacedString);

                if (isValid(replacedString) && replacedString.length() > max) {
                    max = replacedString.length();
                }
                //System.out.println("Replaced string: " + replaceCharacter(s, list.get(i), list.get(j)));
                //charsToRemove = uniqueChars.removeAll(charsToLeave);
                //System.out.println("Need to remove: " + charsToRemove);
            }
        }
        
        System.out.println(max);
    }
	
	public static void main(String[] args) {
		//String str = "ggzczxoxwqeihjsswxwxkuxqwcyeuxrppajcyrzahehomrlqzfesagmietjqtwsrioocnjqgggpzzkmxxqlujnqormwffsmhoatqbezymyhxwjtayyilozozzwbhhkewgimejokyvsyobcfprzjdgnhwitwsdssjohhvkvgwpxcnanqufqbskubxxiajpclpraimeozhvpwagabvhjndinvuhfzqlcvbfnkosqdsdzznsibukhlltcgaezcvlsrkbexelggocseryhqyntrolpskbgojetdaidcbcbiwzsemactmumjemlqkbqyqxbgjaqynnworreqbyqyawpqyuorkoqdlvovyqkvyqxffhbfcjabcqribrikvraivghmdssjqywbtkuzhoeltouoztkdjgupiwyowglrtttgcjxnnmvkihxckbayxwcjiyyrymomqclchpiorftyuuuccymzbzobltxojsdzdrtvqwcvclsfbkvxsdcncgzpjwjwvgyxzptjjscmujoslgx";
		//String str = "osvouiezrafgfnwngpgtaqwpubqjtgdglojfchmgxybyhpfyguxpmamutsepmtlnpszyujksvmeratfbiqnfprxmnundbqahowlyvzeuatlfgibmsucxpehxesjpufkbtodqufgorwovyykjbiatvlncuhgkihaiyhrbyqgppqrfihwqypxntjhxhizlarsosjqlzuihidcilwgcizvoyzeyjlyfbecgesphdizllxnegambrxtqthpexhvctybuamfwrgkskwwjxtxhihrchleseyiplwvvdetmndhrmyhdptlqepdkojxbiftarpycvwonrsxkkoiyacvguu";
		String str = "czoczkotespkfjnkbgpfnmtgqhorrzdppcebyybhlcsplqcqogqaszjgorlsrppinhgpaweydclepyftywafupqsjrbkqakpygolyyfksvqetrfzrcmatlicxtcxulwgvlnslazpfpoqrgssfcrfvwbtxaagjfahcgxbjlltfpprpcjyivxu";
		printLongestStringAfterReduction(str);
	}
}
