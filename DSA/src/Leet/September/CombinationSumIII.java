package Leet.September;

import java.util.ArrayList;
import java.util.List;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

 */
public class CombinationSumIII {
    public static void main(String[] args) {
        int k=3;
        int n=9;
        List<List<Integer>> ans = combinationSum3(n,k);
        System.out.println(ans);
    }
    static List<List<Integer>> combinationSum3(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        backtracking(n,k,0,1,new ArrayList<>(),res);
        return res;
    }
    static void backtracking(int n, int k, int total, int i, List<Integer> comb, List<List<Integer>> res){
        if (comb.size()==k && total==n){
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int num=i; num<=9; num++){
            if (comb.contains(num)){
                break;
            }
            comb.add(num);
            backtracking(n,k,total+num,i+1,comb,res);
            comb.removeLast();
        }
    }
}
