package Leet.September;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 8;
        List<List<Integer>> ans = combination(arr,target);
        System.out.println(ans);
    }
    static List<List<Integer>> combination(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        makeCombination(arr,target,new ArrayList<>(),0,0,result);
        return result;
    }

    static void makeCombination(int[] arr, int target, ArrayList<Integer> comb, int index, int total, List<List<Integer>> result){
        if (total == target){
            result.add(new ArrayList<>(comb));
            return;
        }

        if (total>target || index>=arr.length){
            return;
        }
        comb.add(arr[index]);
        makeCombination(arr,target,comb,index,total+arr[index],result);
        comb.removeLast();
        makeCombination(arr,target,comb,index+1,total,result);
    }
}
