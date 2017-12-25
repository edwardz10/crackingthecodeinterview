package hackerrank.staircase;

public class CoinChange {

	static int getCoinChange(int[] coins, int money, int currentCoin) {
		if (money < 0) {
	        return 0;
		}

	    if (money == 1) {
	    	return 1;
	    }		

	    int count = 0;
    	for (int i = currentCoin; i < coins.length; i++) {
   			count += getCoinChange(coins, money - coins[i], i);
    	}
    	
    	return count;
	}
	
	public static void main(String[] args) {
		int[] coins = {2, 5, 3, 6};
		System.out.println(getCoinChange(coins, 10, 2));
	}
}
