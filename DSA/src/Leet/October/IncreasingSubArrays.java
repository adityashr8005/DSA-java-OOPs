package Leet.October;

import java.util.Arrays;
import java.util.List;

/*
Example 1:
Input: nums = [2,5,7,8,9,2,3,4,3,1], k = 3
Output: true

Explanation:
The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
These two subarrays are adjacent, so the result is true.

Example 2:
Input: nums = [1,2,3,4,4,4,4,5,6,7], k = 5
Output: false

Return true if it is possible to find two such subarrays, and false otherwise.
 */
public class IncreasingSubArrays {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,0,-3,4);
        int k = 2;
        System.out.println(hasIncreasingSubArrays(list,k));
    }

    static boolean hasIncreasingSubArrays(List<Integer> nums, int k){
        int n = nums.size();
        for (int i=0; i+ 2*k <=n; i++){
            if (isIncreasing(nums,i,i+k-1) && isIncreasing(nums,i+k, i + 2*k -1)){
                return true;
            }
        }
        return false;
    }

    static boolean isIncreasing(List<Integer> nums, int start, int end){
        for (int i=start; i<end; i++){
            if (!(nums.get(i)<nums.get(i+1))){
                return false;
            }
        }
        return true;
    }
}
