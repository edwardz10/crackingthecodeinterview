package hackerrank.search;

import java.util.LinkedList;
import java.util.List;

public class MinimumLoss {

	static long findMinDiff(List<Long> list, int position) {
		long min = -1;

		for (int i = position + 1; i < list.size(); i++) {
			if (list.get(i) < list.get(position)) {
				if (min == -1) {
					min = list.get(position) - list.get(i);
				} else if (list.get(position) - list.get(i) < min) {
					min = list.get(position) - list.get(i);
				}
			}
		}

		return min;
	}
	
	static List<Long> getMinimumExtremums(long[] a) {
        List<Long> minimumExtremums = new LinkedList<>();
        minimumExtremums.add(a[0]);
        
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < a[i - 1] && a[i] < a[i + 1]) minimumExtremums.add(a[i]);
        }

        minimumExtremums.add(a[a.length - 1]);
        
        return minimumExtremums;
    }
    
    static long minimumLoss(long[] a) {
        List<Long> minimumExtremums = getMinimumExtremums(a);
        long minimum = 100, newMinimum;

        System.out.println("Minimum extremums: " + minimumExtremums);
        for (int i = 0; i < a.length - 1; i++) {
        	newMinimum = findMinDiff(minimumExtremums, i);
        	if (newMinimum != -1 && newMinimum < minimum) {
        		System.out.println("Min diff starting from " + i + " (value=" + a[i] + "): " + newMinimum);
        		minimum = newMinimum;
        	}
        	
        }
        
        return minimum;
    }
	
	public static void main(String[] args) {
		long[] array = {20, 7, 8, 2, 5};
		
		System.out.println(minimumLoss(array));
	}
}
