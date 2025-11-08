package DSA_Kunal.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 */
public class SubSets {
    public static void main(String[] args) {
        int[] arr = {4,4,4,1,4};
        List<List<Integer>> ans = subSets(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> subSets(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        result.add(comb);

        int start;
        int end=0;
        for (int j=0; j<nums.length; j++){
            start=0;
            if (j>0 && nums[j]==nums[j-1]){
                start=end+1;
            }
            end=result.size()-1;
            int n= result.size();
            for (int i = start; i < n; i++) {
                comb = new ArrayList<>(result.get(i));
                comb.add(nums[j]);
                result.add(comb);
            }
        }
        return result;
    }
}
