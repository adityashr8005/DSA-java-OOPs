package Leet.September;

import java.util.ArrayList;
import java.util.List;

/*
Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 */
public class Combination {
    public static void main(String[] args) {
        int n=4;
        int k=2;
        List<List<Integer>> ans = combine(n,k);
        System.out.println(ans);
    }
    static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res = new ArrayList<>();
        combination(n,k,1,new ArrayList<>(), res);
        return res;
    }
    static void combination(int n, int k, int i,List<Integer> comb, List<List<Integer>> result){
        if (comb.size()==k){
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int num=i; num<=n; num++){
            comb.add(num);
            combination(n,k,num+1,comb,result);
            comb.removeLast();
        }
    }
}
