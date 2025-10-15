package Leet.October;

import java.util.Arrays;
import java.util.List;

/*
Example 1:
Input: nums = [2,5,7,8,9,2,3,4,3,1]
Output: 3

Explanation:
The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
These two subarrays are adjacent, and 3 is the maximum possible value of k for which two such adjacent
strictly increasing subarrays exist.

Example 2:
Input: nums = [1,2,3,4,4,4,4,5,6,7]
Output: 2

Explanation:
The subarray starting at index 0 is [1, 2], which is strictly increasing.
The subarray starting at index 2 is [3, 4], which is also strictly increasing.
These two subarrays are adjacent, and 2 is the maximum possible value of k for which two such adjacent
strictly increasing subarrays exist.

Return the maximum possible value of k.
 */
public class IncreasingSubArraysII {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(9,8,7,6,5,4);
        System.out.println(maxIncreasingSubArrays(list));
    }

    static int maxIncreasingSubArrays(List<Integer> nums){
        ///Time Complexity = O(n^3)
//        int n = nums.size();
//        int k = 0;
//        int sub = 1;
//        for (int i=0; i + 2*sub <=n;){
//            if (isIncreasing(nums,i,i+sub-1) && isIncreasing(nums, i+sub,i+ 2*sub -1)){
//                k = sub;
//                sub++;
//            }else {
//                sub++;
//            }
//            if (i+sub*2 > n){
//                i++;
//                sub = k+1;
//            }
//        }
//        return k;
//    }
//
//    static boolean isIncreasing(List<Integer> nums, int start, int end){
//        for (int i=start; i<end; i++){
//            if (!(nums.get(i) < nums.get(i+1))){
//                return false;
//            }
//        }
//        return true;



        ///Time Complexity O(N)
        int n = nums.size();
        int ans = 0, prev = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            cur++;
            // if at the last element or the next is not strictly greater → run ends
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // compute potential k
                ans = Math.max(ans, cur / 2);
                ans = Math.max(ans, Math.min(prev, cur));
                // shift runs
                prev = cur;
                cur = 0;
            }
        }
        return ans;
    }
}
