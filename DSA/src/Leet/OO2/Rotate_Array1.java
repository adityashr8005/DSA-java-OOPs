package Leet.OO2;

import java.util.Arrays;

public class Rotate_Array1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k=2;
        rotate(arr,k);
    }
    static void rotate(int[] nums, int k){
        int n=nums.length;
        k=k%n; //In case k is greater.
        reverse(nums,0,n-1); //Reverse the array
        reverse(nums,0,k-1); //arrange the shifted element to right position
        reverse(nums,k,n-1); //arrange the remaining element to right position

        System.out.println(Arrays.toString(nums));
    }
    static void reverse(int[] nums,int s,int e){
        while (s<e){
            //Swaping the elements
            int temp = nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}
