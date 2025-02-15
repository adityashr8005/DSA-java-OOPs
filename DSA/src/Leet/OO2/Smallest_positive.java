package Leet.OO2;

import java.util.Hashtable;

public class Smallest_positive {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        int ans = firstMissingPositive(nums);
        System.out.println(ans);
    }
    static int firstMissingPositive(int[] nums){
        Hashtable<Integer,Boolean> h = new Hashtable<>();
        for (int n:nums){
            if(n>0 && n<=nums.length){
                h.put(n,true);
            }
        }
        int i;
        for (i=1; i<=nums.length; i++){
            if (!h.containsKey(i)){
                return i;
            }
        }
        return i+1;
    }
}

//Another way but more complexity...

//    static int firstMissingPositive(int[] nums){
//        Hashtable<Integer,Integer> h = new Hashtable<>();
////        Arrays.sort(nums);
//        for (int i=0; i<nums.length; i++){
//            h.put(i,nums[i]);
//        }
//        //-1,0,1,3,4
//        if (h.contains(1)){
//            int a=2;
//            while (a<=nums.length) {
//                if (h.contains(a)) {
//                    a++;
//                }else {
//                    return a;
//                }
//            }
//            return a;
//        }
//        return 1;
//    }
//}
