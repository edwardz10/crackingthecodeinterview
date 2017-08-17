package programming.interviews.exposed.algorithms;

import java.util.HashMap;
import java.util.Map;

public class FibonacciN {

	private static Map<Integer, Integer> fibCache = new HashMap<>();

	public static int fibN(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}

		if (n == 1) return 1;
		if (n == 0) return 0;

		return (fibN(n - 1) + fibN(n - 2));
	}
	
	
	public static int cachedFibN(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must not be less than zero");
		}

		fibCache.put(0, 0);
		fibCache.put(1, 1);

		return recursiveCachedFibN(n);
	}

	private static int recursiveCachedFibN(int n) {
		if (fibCache.containsKey(n)) {
			return fibCache.get(n);
		}

		int value = recursiveCachedFibN(n - 1) + recursiveCachedFibN(n - 2);
		fibCache.put(n, value);

		return value;
	}
	
	public static void main(String[] args) {
		int fib;
		
		final long nonCachedStart = System.nanoTime();
		fib = fibN(45);
		final long nonCachedFinish = System.nanoTime();

		final long cachedStart = System.nanoTime();
		fib = cachedFibN(45);
		final long cachedFinish = System.nanoTime();

		
		System.out.printf("Non cached time: %d nanoseconds%n",
				nonCachedFinish - nonCachedStart);
		System.out.printf("Cached time: %d nanoseconds%n",
		cachedFinish - cachedStart);
	}
}
