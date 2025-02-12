package Leet.OO1;

import java.util.Arrays;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 2;
        rotate(arr,k);
    }
    static void rotate(int[] nums, int k){
        int n = nums.length;
        k=k%n;
        for (int i=0; i<k; i++){
          rotateOnce(nums);
        }
            System.out.println(Arrays.toString(nums));
    }
    static int[] rotateOnce(int[] nums){
        int t = nums[nums.length-1];
        System.arraycopy(nums,0,nums,1,nums.length-1);
        nums[0] = t;
        return nums;
    }
}
