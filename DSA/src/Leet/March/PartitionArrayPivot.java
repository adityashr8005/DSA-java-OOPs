package Leet.March;

import java.util.Arrays;

/*
Example 1:
---------
Input: nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
Explanation:
The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
The relative ordering of the elements less than and greater than pivot is also maintained.
 [9, 5, 3] and [12, 14] are the respective orderings.
 */
public class PartitionArrayPivot {
    public static void main(String[] args) {
        int[] arr = {9,12,5,10,14,3,10};
        int pivot = 10;
        int[] ans = pivotArray(arr,pivot);
        System.out.println(Arrays.toString(ans));
    }
    static int[] pivotArray(int[] nums,int pivot){
        int index=0;
        int[] a = new int[nums.length];

        for (int i=0; i<nums.length; i++){
            if (nums[i]<pivot){
                a[index++]=nums[i];
            }
        }
        for (int i=0; i<nums.length; i++){
            if (nums[i]==pivot){
                a[index++]=nums[i];
            }
        }
        for (int i=0; i<nums.length; i++){
            if (nums[i]>pivot){
                a[index++]=nums[i];
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }
}
