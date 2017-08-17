package code.interview.algorithms.bits;

public class SameAmountOfBits {

	public static String printBinary(int i) {
		return Integer.toBinaryString(i);
	}
	
	public static int getAmoutOfBits(int number) {
		int amount = 0;

		while (number > 1) {
			if (number % 2 == 1) {
				amount++;
			}

			number >>= 1;
		}

		return amount;
	}
	
	public static void main(String[] args) {
		int number = 87;
		int amountOfBits = getAmoutOfBits(number);

		int tmp1 = number, tmp2 = number;
		do {
			tmp1--;
			if (getAmoutOfBits(tmp1) == amountOfBits) break;
		} while (tmp1 > 0);

		do {
			tmp2++;
			if (getAmoutOfBits(tmp2) == amountOfBits) break;
		} while (true);

		
		System.out.println("Number of bits of number " + number + "(" + printBinary(number) + "): " + amountOfBits);
		System.out.println("Closest numbers with same amount of bits: " + tmp1 + "(" + printBinary(tmp1) + ") and " + tmp2 + "(" + printBinary(tmp2) + ")");
	}
}
