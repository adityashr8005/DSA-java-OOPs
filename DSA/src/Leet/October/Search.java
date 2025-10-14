package Leet.October;

import java.util.Arrays;

/*
Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
 */
public class Search {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(arr,target));
    }

    public static int search(int[] nums, int target){

        int s = 0;
        int e = nums.length-1;

//        while (s <= e){
//            int mid=s+(e-s) / 2;
//            if (target == nums[mid]){
//                return mid;
//            } else if (nums[mid] >= nums[s]) {
//                if (nums[s] <= target && target <= nums[mid]){
//                    e = mid -1;
//                }else {
//                    s = mid +1;
//                }
//            }else {
//                if (nums[mid] <= target && target <= nums[e] ){
//                    s = mid + 1;
//                }else {
//                    e = mid - 1;
//                }
//            }
//        }

        while (s <= e){
            int mid = s + (e-s) / 2;
            if (nums[mid]==target){
                return mid;
            } else if (nums[s] <= nums[mid]) {
                if (nums[s] <= target && target <= nums[mid]){
                    e = mid - 1;
                }else {
                    s = mid + 1;
                }
            }else {
                if (target <= nums[mid] && target <= nums[e]){
                    e = mid - 1;
                }else {
                    s = mid + 1;
                }
            }
        }

        return -1;
    }
}
