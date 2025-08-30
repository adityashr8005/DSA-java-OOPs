package Recursion;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = permute(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> permute(int[] arr){
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList,new ArrayList<>(),arr);
        return resultList;
    }

    static void backtrack(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] arr){
        if (tempList.size()== arr.length){
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for (int num:arr){
            //skip if we have the same element
            if (tempList.contains(num)){
                continue;
            }
            tempList.add(num);//Add the other element
            backtrack(resultList,tempList,arr);//Go back to try the other element.
            tempList.removeLast();//Remove the last element of tempList
        }
    }
}
