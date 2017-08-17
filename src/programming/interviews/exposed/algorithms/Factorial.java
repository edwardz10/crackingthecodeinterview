package programming.interviews.exposed.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Factorial {

	static Map<Long, Long> cache = new HashMap<>();

	public static Long getFactorial(Long n) {
		if (n == 1) {
			return 1L;
		}

		Long f = cache.get(n);
		if (f == null) {
			System.out.println("Factorial of " + n + " is not cached");
			f = n * getFactorial(n - 1);
			cache.put(f, n);
		} else {
			System.out.println("Factorial of " + n + " is cached: " + f);
		}

		return f;
	}

	public static void main(String[] args) {
		Long n = 23L;
		Long f = getFactorial(n);

		System.out.println("Factorial of " + n + " is " + f);
	}
}
