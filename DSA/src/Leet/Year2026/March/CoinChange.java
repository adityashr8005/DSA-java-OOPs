package Leet.Year2026.March;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and
an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
public class CoinChange {

    public static int minCoin(int[] coins, int amount, int[] dp){
        int ans = Integer.MAX_VALUE;

        if (amount == 0) return 0;
        for (int i=0; i<coins.length; i++){
            int subAns = Integer.MAX_VALUE;

            if (amount-coins[i] >= 0){
                if (dp[amount-coins[i]] != -1){
                    subAns = dp[amount-coins[i]];
                }else {
                    subAns = minCoin(coins,amount-coins[i], dp);
                }
            }

            if (subAns != Integer.MAX_VALUE && subAns+1 < ans){
                ans = subAns + 1;
            }
        }
        dp[amount] = ans;
        return ans;
    }
    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;

        int ans = minCoin(coins,amount,dp);
        if (ans == Integer.MAX_VALUE) return -1;

        return ans;
    }

    public static void main(String[] args) {
        int[] coins = {3,3,5};
        int amount = 4;

        System.out.println(coinChange(coins,amount));
    }
}
