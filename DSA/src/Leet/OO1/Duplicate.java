package Leet.OO1;

import java.util.Arrays;

public class Duplicate {
    public static void main(String[] args) {
        //Initializing array
        int[] arr = {1,2,3};
        System.out.println(duplicate(arr));
    }

    static boolean duplicate(int[] nums) {

//        int i=0, j=1;
//        if (nums.length==1 || nums.length==0){
//            return false;
//        }
//        do{
//            if (nums[i]==nums[j]){
//                return true;
//            }else{
//                while (j<nums.length-1){
//                    if (nums[i]==nums[j+1] || nums[j]==nums[j+1]){
//                        return true;
//                    }
//                    j++;
//                }
//            }
//            i++;
//            j=i+1;
//        }while (j<=nums.length-2);
//        return false;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
