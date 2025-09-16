package Leet.September;

import java.util.HashMap;
/*
Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
    static int majorityElement(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();

        int majorValue = 0;
        int count = 0;

        for (int num : nums){
           map.put(num,1+map.getOrDefault(num,0));
           if (map.get(num)>count){
               majorValue = num;
               count = map.get(num);
           }
        }
        return majorValue;
    }
}
