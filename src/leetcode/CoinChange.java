package leetcode;

import org.junit.Test;

public class CoinChange {
	@Test
	public void fun() {
		int coins[] = { 1, 2, 5 };
		int amount = 11;
		int method = CoinChange(coins, amount);
		System.out.println(method);
	}

	private int CoinChange(int[] coins, int amount) {
		// TODO Auto-generated method stub
		if (amount == 0) {
			return 0;
		}
		if (coins == null || coins.length == 0) {
			return -1;
		}
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int res = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] > i) {
					continue;
				}
				if (dp[i - coins[j]] == -1) {
					continue;
				}
				dp[i] = 1 + dp[i - coins[j]];
				res = Math.min(res, dp[i]);
			}
			dp[i] = res;
		}
		return dp[amount];
	}
}
