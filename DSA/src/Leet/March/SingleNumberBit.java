package Leet.March;

import java.util.HashMap;
/*
Return single exist element from array.
 */
public class SingleNumberBit {
    public static void main(String[] args) {
        int[] array = {1,4,3,2,1,4,2};
        int ans = singleNumber(array);
        System.out.println(ans);
    }
    static int singleNumber(int[] nums){
//        HashMap<Integer,Integer> map = new HashMap<>();
//        int index=1;
//        for (int i=0; i<nums.length-1; i++){
//            map.put(nums[i],index++);
//        }
//        System.out.println(map);
//        for (int i=0; i<nums.length; i++){
//            if (map.containsValue(1)){
//                return nums[i];
//            }
//        }
        int num=0;
        for (int i=0; i<nums.length; i++){
            num=num^nums[i];
        }
        return num;
    }
}

