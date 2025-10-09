package Leet.October;

import java.util.*;

/*
Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 */
public class FourSum {
    public static void main(String[] args) {
        int[] arr = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> ans = fourSum(arr,target);
        System.out.println(ans);
        //[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        //[-3,0,1,2],[-2,-1,1,2],[-2,0,0,2]
    }

    public static List<List<Integer>> fourSum(int[] nums, int target){

        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums); //

        for (int a = 0; a<nums.length-3; a++) {
            for (int b = a + 1; b < nums.length - 2; b++) {
                int c = b + 1;
                int d = nums.length - 1;

                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        s.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        list.addAll(s);
        return list;
    }
}
