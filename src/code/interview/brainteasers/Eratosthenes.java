package code.interview.brainteasers;

public class Eratosthenes {

	static boolean[] sieveOfEratosthenes(int max) {
		boolean[] flags = new boolean[max + 1];

		init(flags); // Set all flags to true other than 0 and 1
		int prime = 2;
		
		while (prime <= Math.sqrt(max)) {
			crossOff(flags, prime);

			prime = getNextPrime(flags, prime);

			if (prime >= flags.length) {
				break;
			}
		}
		
		return flags;
	}

	private static void init(boolean[] flags) {
		for (int i = 2; i < flags.length; i++) {
			flags[i] = true;
		}
		
	}

	static void crossOff(boolean[] flags, int prime) {
		for (int i = prime * prime; i < flags.length; i += prime) {
			flags[i] = false;
		}
	}

	static int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;

		while (next < flags.length && !flags[next]) {
			next++;
		}

		return next;
	}
	
	public static void main(String[] args) {
		boolean[] flags = sieveOfEratosthenes(64);

		for (int i = 0; i < flags.length; i++) {
			if (flags[i]) {
				System.out.println(i + " is prime!");
			}
		}
	}
}
