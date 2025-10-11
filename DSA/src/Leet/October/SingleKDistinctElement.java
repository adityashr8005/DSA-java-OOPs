package Leet.October;

import java.util.HashMap;

public class SingleKDistinctElement {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,5,7,22,10,10,11,19,33};
        int k = 6;
        System.out.println(distinctElement(arr,k));
    }

    public static int distinctElement(int[] arr, int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else {
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
        }

        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i] + " : " + map.get(arr[i]));
        }

        int i=0;
        while (k!=0) {
            for (i = 0; i < arr.length; i++) {
                if (map.get(arr[i]) == 1) {
                    k--;
                }
                if (k == 0) {
                    break;
                }
            }
        }

        return arr[i];
    }
}
