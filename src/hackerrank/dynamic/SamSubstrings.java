package hackerrank.dynamic;

import java.util.HashSet;
import java.util.Set;

public class SamSubstrings {

    static Set<Long> numbers = new HashSet<>();

    static void fillNumbersSet(String ball) {
        for (int i = 0; i < ball.length(); i++) {
            for (int j = i + 1; j <= ball.length(); j++) {
                Long value = Long.valueOf(ball.substring(i, j));
                numbers.add(value);
            }
        }
    }

    static Long getSum() {
    	Long sum = 0L;
    	for (Long l : numbers) {
    		sum += l;
    	}
    	return sum;
    }
    
    static long substrings(String balls) {
        fillNumbersSet(balls);
        //System.out.println("Numbers: " + numbers);
        return getSum();
    }

	public static void main(String[] args) {
		System.out.println(substrings("16"));
	}
}
