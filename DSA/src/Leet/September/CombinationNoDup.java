package Leet.September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationNoDup {
    public static void main(String[] args) {
        int[] arr={2,5,2,1,2};
        int target=5;
        List<List<Integer>> ans = combinationNoDup(arr,target);
        System.out.println(ans);
    }
    static List<List<Integer>> combinationNoDup(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combination(candidates,target,0,new ArrayList<>(),result);
        return result;
    }

    static void combination(int[] arr,int target,int i,List<Integer> comb,List<List<Integer>> result){
        if (target<0){
            return;
        }
        if (target==0){
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int index=i; index<arr.length;index++){
            if (index>i && arr[index]==arr[index-1]){
                continue;
            }
            comb.add(arr[index]);
            combination(arr,target-arr[index],index+1,comb,result);
            comb.removeLast();
        }
    }
}
