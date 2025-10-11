package Leet.October;

import java.util.*;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] arr = {0,0,1,2};
        int[] ans = singleNumberIII(arr);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] singleNumberIII(int[] nums){

        int k=2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //This will print count/value for each element in array nums...
        for (int i=0; i<nums.length; i++){
            System.out.println(nums[i] + " : " + map.get(nums[i]));
        }

        //This loop will print all the key and its opposite value in hashmap.
//        for (int key : map.keySet()){
//            System.out.println(key + " : " + map.get(key));
//        }

        //It will print the key for (value=1)
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                System.out.println(entry.getKey());
//            }
//        }


        List<Integer> list = new ArrayList<>();
        int i;
        while (k!=0) {
            for (i = 0; i < nums.length; i++) {
                if (map.get(nums[i]) == 1) {
                    list.add(nums[i]);
                    k--;
                }
                if (k == 0) {
                    break;
                }
            }
        }

        int[] arr = new int[2];
        arr[0] = list.get(0);
        arr[1] = list.get(1);
        return arr;
    }
}
