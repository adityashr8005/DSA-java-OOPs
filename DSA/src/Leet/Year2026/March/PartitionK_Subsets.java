package Leet.Year2026.March;

import java.util.HashMap;

/*
Given an integer array nums and an integer k,
return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:
Input: nums = [1,2,3,4], k = 3
Output: false

Constraints:
1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].
 */


//BackTracking -> BitMasking -> Memoization
//Optimized
public  class PartitionK_Subsets {
    public static boolean solve(int[] nums, int k, int mask, int currSum, int target, HashMap<Integer,Boolean> map){
        //Base Case
        if (k == 0){
            return true;
        }

        if (currSum == target){
            boolean result = solve(nums,k-1,mask,0,target,map);
            map.put(mask,result);
        }
        if (map.containsKey(mask)){
            return map.get(mask);
        }

        for (int i=0; i<nums.length; i++){
            if ((mask & (1 << i)) == 0){
                if (currSum+nums[i] > target) continue;

                int newMask = mask | (1 << i);
                if (solve(nums,k,newMask,currSum+nums[i],target,map)){
                    return true;
                }
            }
        }

        map.put(mask,false);
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum%k != 0) return false;
        int target = sum/k;

        HashMap<Integer,Boolean> map = new HashMap<>();
        return solve(nums,k,0,0,target,map);
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4};
        int k = 3;
        boolean ans = canPartitionKSubsets(nums,k);
        System.out.println(ans);
    }
}


//Only BackTracking -> Not fully Optimized -> recalculating the subProblems

//public class PartitionK_Subsets {
//    public static boolean solve(int[] nums, int k, int i, int bucket, int bucketSum, int required, boolean[] alreadyPicked){
//        if (bucket == k){
//            return true;
//        }
//
//        if (bucketSum == required){
//            return solve(nums,k,0,bucket+1,0,required,alreadyPicked);
//        }
//
//        if (bucketSum > required) return false;
//        if (i >= nums.length) return false;
//
//        if (alreadyPicked[i]){
//            return solve(nums,k,i+1,bucket,bucketSum,required,alreadyPicked);
//        }else {
//            //Take
//            bucketSum += nums[i];
//            alreadyPicked[i] = true;
//            boolean take = solve(nums,k,i+1,bucket,bucketSum,required,alreadyPicked);
//
//            //Not_took
//            bucketSum -= nums[i];
//            alreadyPicked[i] = false;
//            boolean notTake = solve(nums,k,i+1,bucket,bucketSum,required,alreadyPicked);
//
//            return take || notTake;
//        }
//    }
//
//    public static boolean canPartitionKSubsets(int[] nums, int k){
//        int sum = 0;
//        for (int num:nums){
//            sum += num;
//        }
//
//        if (sum%k != 0) return false;
//        int reqSum = sum/k;
//        boolean[] alreadyPicked = new boolean[nums.length];
//
//        return solve(nums,k,0,0,0,reqSum,alreadyPicked);
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {4,4,4};
//        int k = 3;
//        boolean ans = canPartitionKSubsets(nums,k);
//        System.out.println(ans);
//    }
//}
