package Leet.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Example 1:
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.

Example 2:
Input: nums = [1,2,4,8]
Output: [1,2,4,8]

Constraints:
1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.
 */
public class LargestDivSubset {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(largestDivisibleSubset(arr));
    }
    static List<Integer> largestDivisibleSubset(int[] nums){
        List<Integer> list = new ArrayList<>();

        if (nums.length==0){
            return list;
        }
        if (nums.length==1){
            list.add(nums[0]);
            return list;
        }

        //Sorting an array(nums).
        Arrays.sort(nums);

        //Declaration of an array of size nums.length;
        int[] arr = new int[nums.length];
        //Filling all elements of arr with 1.
        Arrays.fill(arr, 1);

        int max=0;
        //Nested loop to find max number of elements for the largest Divisible Subset
        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[i]%nums[j]==0 && 1+arr[j]>arr[i]){
                    arr[i]=1+arr[j];
                }
                if (max<arr[i]){
                    max=arr[i];
                }
            }
        }

        int temp=-1;
        //Loop to add an element to a list of maximum subset.
        for (int i=arr.length-1; i>=0; i--){
            if ((arr[i] == max) && ((((temp % nums[i]) == 0) || temp == -1))){
                list.add(nums[i]);
                max -= 1;
                temp = nums[i];
            }
        }
        return list;
    }
}
