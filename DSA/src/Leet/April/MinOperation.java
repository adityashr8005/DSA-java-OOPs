package Leet.April;

/*
Example 1:
Input: nums = [5,2,5,4,5], k = 2
Output: 2
Explanation:
The operations can be performed in order using valid integers 4 and then 2.

Example 2:
Input: nums = [2,1,2], k = 2
Output: -1
Explanation:
It is impossible to make all the values equal to 2.

Example 3:
Input: nums = [9,7,5,3], k = 1
Output: 4
Explanation:
The operations can be performed using valid integers in the order 7, 5, 3, and 1.
 */
import java.util.Arrays;

public class MinOperation {
    public static void main(String[] args) {
        int[] arr={9,7,5,3};
        int k=1;
        System.out.println(minimunOperation(arr,k));
    }
    static int minimunOperation(int[] nums, int k){

        Arrays.sort(nums);

        for (int num : nums) {
            if (num < k) {
                return -1;
            }
        }

        int count=0;
        while (nums[0]!=k || nums[nums.length-1]!=k) {
            int h = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                if (h > nums[i]) {
                    h = nums[i];
                    break;
                }
                if (i==0 && h>k){
                    h=k;
                }
            }

            int i = nums.length - 1;
            while (nums[i] != h) {
                nums[i] = h;
                if (i!=0) {
                    i--;
                }
            }
            count++;
        }

        return count;
    }
}
