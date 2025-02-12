package Leet.OO1;

/*
Example 1:

Input: numbers = [10,2]
Output: "210"
Example 2:

Input: numbers = [3,30,34,5,9]
Output: "9534330"
 */
public class Largest_number {
    public static void main(String[] args) {
        int[] nums = {10,2,3,11};
        String ans = largestnumber(nums);
        System.out.println(ans);
    }
    static String largestnumber(int[] nums){
        String s = "";
//        s= String.valueOf(nums[0]);

        int max=0;
        for (int i=0;i<nums.length-1;i++){
           if (nums[i+1]>nums[max]){
               max = i+1;
           }
           s=String.valueOf(nums[max]);
        }
            return s;
    }
}
