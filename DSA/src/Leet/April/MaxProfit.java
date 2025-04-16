package Leet.April;

/*
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sells on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 are not allowed because you must buy before you sell.\

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] array = {1,3};
        System.out.println(maxProfit(array));
    }
    static int maxProfit(int[] prices){
        int n=prices.length-1;
        if (n==0){
            return 0;
        }

        int i=n;
        int buy=prices[i-1];
        int sell=prices[i];

        int max=0;
        int profit=0;

        for (i=n; i>0; i--){
            if (buy < sell){
                profit = sell-buy;
            }
            if (profit > max){
                max=profit;
            }
            if (prices[i-1]>sell){
                sell=prices[i-1];
            }
            if (i>1 && (prices[i-2]<buy || sell==prices[i-1])){
                buy=prices[i-2];
            }
        }
        return max;
    }
}
