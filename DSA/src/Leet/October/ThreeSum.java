package Leet.October;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,-1,1,2,-4};
        List<List<Integer>> list = threeSum(arr);
        System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums){

        //Solved but not for longer input...
        ///----------------------------------
//        List<List<Integer>> outerList = new ArrayList<>();
//
//        Arrays.sort(nums);
//
//        for (int i=0; i<nums.length; i++){
//            if (i > 0 && nums[i] == nums[i-1]) continue;
//
//            for (int j=i+1; j<nums.length; j++){
//                if (j > i + 1 && nums[j] == nums[j-1]) continue;
//
//                for (int k=j+1; k<nums.length; k++){
//                    if (k > j + 1 && nums[k] == nums[k-1]) continue;
//
//                    if (nums[i]+nums[j]+nums[k]==0){
//                        List<Integer> innerList = new ArrayList<>();
//                        innerList.add(nums[i]);
//                        innerList.add(nums[j]);
//                        innerList.add(nums[k]);
//                        outerList.add(innerList);
//                    }
//                }
//            }
//        }
//
//        return outerList;

        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++){
            int j=i+1, k=nums.length-1;

            while (j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if (sum==0){
                    s.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                } else if (sum<0) {
                    j++;
                }else {
                    k--;
                }
            }
        }
        list.addAll(s);
        return list;
    }
}
