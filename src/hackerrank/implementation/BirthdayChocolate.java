package hackerrank.implementation;

public class BirthdayChocolate {

	static int solve(int n, int[] s, int d, int m) {
        int sum = 0;
        int count = 0;

        for (int i = 0; i < m; i++) {
            sum += s[i];
        }

        System.out.println("Sum: " + sum);
        
        if (sum == d) count = 1;
        
        for (int i = 0; i < n-m; i++) {
            sum -= s[i];
            sum += s[m + i];

            System.out.println("Sum: " + sum);
            if (sum == d) count++;
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] s = {2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1};
		
		System.out.println(solve(19, s, 18, 7));
	}
}
