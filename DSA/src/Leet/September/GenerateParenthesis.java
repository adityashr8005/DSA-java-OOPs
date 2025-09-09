package Leet.September;
/*
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 */


import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n=3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }
    static List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        backtracking(0,0,"",res,n);
        return res;
    }
    static void backtracking(int openP, int closeP, String s, List<String> res, int n){
        if (openP+closeP == n*2){
            res.add(s);
            return;
        }

        if (openP<n){
            backtracking(openP+1,closeP,s + "(", res, n);
        } if (closeP<openP){
            backtracking(openP,closeP+1,s + ")", res, n);
        }
    }
}
