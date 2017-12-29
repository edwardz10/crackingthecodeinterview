package hackerrank.dynamic;

public class SherlockCost {

	static void printArray(long[] array) {
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
    }

    static long getSum(long[] array) {
        long sum = 0;
        for (int i = 1; i < array.length; i++) {
            sum += Math.abs(array[i] - array[i - 1]);
        }
        return sum;
    }

    
    static long getMaxSum(long[] array) {
        long maxSum = 0;
        long evenSum = 0, oddSum = 0;

        for (int i = 0; i < array.length; i += 2) {
            evenSum += array[i];
        }

        for (int i = 1; i < array.length; i += 2) {
            oddSum += array[i];
        }

        if (evenSum > oddSum) {
            for (int i = 1; i < array.length; i += 2) {
                array[i] = 1;
            }
        } else {
            for (int i = 0; i < array.length; i += 2) {
                array[i] = 1;
            }
        }
        
        System.out.println("Even sum: " + evenSum + ", odd sum: " + oddSum);
        printArray(array);
        maxSum = getSum(array);
        
        return maxSum;
    }
	
	public static void main(String[] args) {
//		long[] array = {75, 26, 45, 72, 81, 47, 29, 97, 2, 75, 25, 82, 84, 17, 56, 32, 2, 28, 37, 57, 39, 18};
//		long[] array = {79, 6, 40, 68, 68, 16, 40, 63, 93, 49, 91};
		long[] array = {55, 68, 31, 80, 57, 18, 34, 28, 76, 55};
//		long[] array = {10, 1, 10, 1};
//		long[] array = {80, 22, 45, 11, 67, 67, 74, 91, 4, 35, 34, 65, 80, 21, 95, 1, 52, 25, 31, 2, 53};
		
		System.out.println(getMaxSum(array));
	}
}
