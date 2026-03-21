package Leet.Year2026.March;

/*
Given an integer array nums, return true if you can partition the array into two subsets
such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100
 */
public class PartitionSubsets {
    static Boolean[][] dp;
    public static boolean solve(int[] nums, int i, int x){
        if (x == 0) return true;

        if (i >= nums.length) return false;
        if (dp[i][x] != null){
            return dp[i][x];
        }

        boolean take = false;
        if (nums[i] <= x){
            take = solve(nums, i+1, x-nums[i]);
        }
        boolean not_Took = solve(nums, i+1, x);

        return dp[i][x] = take || not_Took;
    }

    public static boolean canPartition(int[] nums){
        //Recursion
        int sum = 0;
        for (int num:nums){
            sum += num;
        }

        if (sum%2 != 0) return false;

        int x = sum/2;
        dp = new Boolean[nums.length][x+1];

        return solve(nums, 0, x);


        //Dynamic Programming
//        int sum = 0;
//        for (int num : nums){
//            sum += num;
//        }
//
//        if (sum % 2 != 0) return false;
//
//        int target = sum / 2;
//
//        boolean[] dp = new boolean[target + 1];
//        dp[0] = true; // base case
//
//        for (int num : nums) {
//            for (int j = target; j >= num; j--) {
//                dp[j] = dp[j] || dp[j - num];
//            }
//        }
//
//        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        boolean ans = canPartition(nums);
        System.out.println(ans);
    }
}


/*
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // base case

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
 */
