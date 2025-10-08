package Leet.October;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99
 */
public class SingleNumberII {
    public static void main(String[] args) {
        int[] arr = {2,2,3,2};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums){
//        int val = 0;
//        for (int i=0; i<nums.length; i++){
//            val ^= nums[i];
//        }
//        return val;

        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
