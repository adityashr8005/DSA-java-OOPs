package Leet.Year2026.March;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected,
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: nums = [1,2,3]
Output: 3

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */
public class HouseRobberII {
    public static int helper(int[] nums, int start, int last){
//        int prev1 = 0; //dp[i-2]
//        int prev2 = 0; //dp[i-1]
//        for (int i=start; i<=last; i++){
//            int total = prev1 + nums[i];
//            int prev = prev2;
//
//            int current = Math.max(total,prev);
//
//            prev1 = prev2;
//            prev2 = current;
//        }
//        return prev2;


        int n = last - start + 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        if (n>1){
            dp[1] = Math.max(nums[start], nums[start+1]);
        }

        for (int i=2; i< n; i++){
            int total = dp[i-2] + nums[start+i];
            int prev = dp[i-1];

            dp[i] = Math.max(total,prev);
        }
        return dp[n-1];
    }
    public static int robHouse(int[] nums){
        int n = nums.length;

        if (n == 0) return 0;

        if (n == 1) return nums[0];

        if (n == 2) return Math.max(nums[0], nums[1]);

        return (Math.max(helper(nums,0,n-2),
                helper(nums,1,n-1)));
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(robHouse(nums));
    }
}
