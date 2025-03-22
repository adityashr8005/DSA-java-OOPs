package Leet.March;

import java.util.Arrays;

/*
Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */

//This qn. in leetcode is for not removing the duplicate element but to count the first k unique element after arrangement.
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int ans = removeDuplicate(arr);
        System.out.println(ans);
    }
    static int removeDuplicate(int[] nums){
      int index=1;
      for (int i=1; i<nums.length; i++){
          if (nums[i]!=nums[i-1]){
              nums[index++]=nums[i];
          }
      }
//      int[] newArr = new int[index];
//      for (int i=0; i<index; i++){
//          newArr[i]=nums[i];
//      }
    return index;
    }
}
