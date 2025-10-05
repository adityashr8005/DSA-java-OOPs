package Leet.October;

/*
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7};
        int target = 6;
        System.out.println(searchInsert(arr,target));
    }
    public static int searchInsert(int[] nums, int target){
        int s = 0;
        int e = nums.length-1;
        int mid=0;
        while (s<=e){
            mid = (s+e) / 2;
            if (nums[mid]==target){
                return mid;
            } else if (nums[mid]>target) {
                e = mid-1;
            }else {
                s = mid+1;
            }
        }
        if (nums[mid]<target){
            return mid+1;
        }
        return mid;
    }
}
