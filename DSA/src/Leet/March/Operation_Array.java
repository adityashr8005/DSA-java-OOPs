package Leet.March;

import java.util.Arrays;

/*
If nums[i] == nums[i + 1], then multiply nums[i] by 2 and set nums[i + 1] to 0. Otherwise, you skip this operation.
After performing all the operations, shift all the 0's to the end of the array.

Input: nums = [1,2,2,1,1,0]
Output: [1,4,2,0,0,0]
 */
public class Operation_Array {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,0};
        int[] ans = applyOperation(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int[] applyOperation(int[] nums){

        for (int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1]){
                nums[i]=nums[i] * 2;
                nums[i+1]=0;
            }
        }
        //[1, 4, 0, 2, 0, 0]
        int k =0;
        int index=0;
        int[] a = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=k){
                a[index]=nums[i];
                index++;
            }
        }
        return Arrays.copyOf(a,a.length);
    }
}
