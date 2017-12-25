package hackerrank.primes;

import java.util.LinkedList;
import java.util.List;

public class PrimeNumbers {

    static List<Integer> primes = new LinkedList<>();
    
    public static boolean isPrime(int number) {
        if (number == 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        
        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }        

        return true;
    }
	
	public static void main(String[] args) {
		int[] array = {30, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 441, 484, 529, 576, 625, 676, 729, 784, 841, 907};

		for (Integer a : array) {
			System.out.println(isPrime(a) ? "Prime" : "Not prime");
		}
	}
}
