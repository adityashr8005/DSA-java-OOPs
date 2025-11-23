package Leet.November;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Example 1:
Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).

Example 2:
Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.

Example 3:
Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 */
public class MaxSum {
    public static void main(String[] args) {
        int[] arr = {3,6,5,1,8};
        System.out.println(maxSumDivThree(arr));
    }

    public static int maxSumDivThree(int[] nums){
        int sum = 0;
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();

        for (int num : nums){
            sum = sum + num;

            if (num%3 == 1){
                rem1.add(num);//Adding to list rem1 if rem=0
            } else if ((num%3) == 2) {
                rem2.add(num);//Adding to list rem2 if rem=2
            }
        }
        Collections.sort(rem1);
        Collections.sort(rem2);

        int rem = sum % 3;

        //Case 1:
        if (rem == 0) return sum;

        //Case 2:
        int opt1 = Integer.MIN_VALUE;
        int opt2 = Integer.MIN_VALUE;
        if (rem == 1) {
            //Remove one smallest with remainder 1
            if (!rem1.isEmpty()){
                opt1 = sum - rem1.getFirst();
            }
            //Remove two smallest with remainder 2
            if (rem2.size() >= 2){
                opt2 = sum - rem2.get(0) - rem2.get(1);
            }

        }

        //Case 3:
        else {
            //Remove one smallest with remainder 2
            if (!rem2.isEmpty()){
                opt1 = sum - rem2.getFirst();
            }
            //Remove two smallest with remainder 1
            if (rem1.size() >= 2){
                opt2 = sum - rem1.get(0) - rem1.get(1);
            }

        }
        return Math.max(opt1,opt2);
    }
}
