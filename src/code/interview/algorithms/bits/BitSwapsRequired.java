package code.interview.algorithms.bits;

public class BitSwapsRequired {

	public static int bitSwapsRequired(int a, int b) {
		int count = 0;
		
		for (int c = a ^ b; c > 0; c >>= 1) {
			count += c & 1;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int a = 23, b = 44;
		System.out.println("A: " + a + ": " + Integer.toBinaryString(a));
		System.out.println("B: " + b + ": " + Integer.toBinaryString(b));

		System.out.println("Bit swaps between " + a + " and " + b + ": " + bitSwapsRequired(a, b));
	}
}
