package hackerrank.staircase;

import java.util.HashMap;
import java.util.Map;

public class Staircase {

	static Map<Integer, Integer> map = new HashMap<>();
	
	static int countOptions(int n) {
		if (n < 0) {
	        return 0;
		}

	    if (n == 0) {
	        return 1;
	    }

	    if (map.containsKey(n)) {
	    	return map.get(n);
	    } else {
	    	int count = countOptions(n - 1) + countOptions(n - 2) + countOptions(n - 3);
	    	map.put(n,  count);
	    	return count;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(countOptions(7));
	}
}
