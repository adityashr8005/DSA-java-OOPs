package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSeqNoRecursion {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        List<List<Integer>> ans = subSeq(arr);
        System.out.println(ans);

        List<List<Integer>> ans2 = subSeqDuplicate(arr);
        System.out.println(ans2);
    }
    static List<List<Integer>> subSeq(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num:arr){
            int n= outer.size();
            for (int i=0; i<n; i++){
                List<Integer> Internal = new ArrayList<>(outer.get(i));
                Internal.add(num);
                outer.add(Internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subSeqDuplicate(int[] nums){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start;
        int end=0;
        for (int i=0; i<nums.length; i++){
            start=0;
            if (i>0 && nums[i]==nums[i-1]){
                start=end+1;
            }
            end= outer.size()-1;
            int n= outer.size();
            for (int j=start; j<n; j++){
                List<Integer> Internal = new ArrayList<>(outer.get(j));
                Internal.add(nums[i]);
                outer.add(Internal);
            }
        }
        return outer;
    }
}
