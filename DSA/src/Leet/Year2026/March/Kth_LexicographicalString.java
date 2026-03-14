package Leet.Year2026.March;

/*
A happy string is a string that:
consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).

For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and
strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.
Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

Example 1:
Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".

Example 2:
Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.

Example 3:
Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3
["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"

Constraints:
1 <= n <= 10
1 <= k <= 100
 */


import java.util.ArrayList;

public class Kth_LexicographicalString {

    public static void getAllString(int n, StringBuilder str, ArrayList<String> list){
        if (str.length() == n){
            list.add(String.valueOf(str));
            return;
        }

        for (char ch='a'; ch <= 'c'; ch++){
            int index = str.length();
            if (!str.isEmpty() && str.charAt(index-1) == ch){
                continue;
            }

            str.append(ch);

            getAllString(n,str,list);

            str.deleteCharAt(str.length()-1);
        }
    }

    public static String getHappyString(int n, int k){
        StringBuilder str = new StringBuilder();


        ArrayList<String> list = new ArrayList<>();

        getAllString(n, new StringBuilder(String.valueOf(str)), list);

        if (list.size() < k){
            return "";
        }

        return list.get(k-1);
    }
    public static void main(String[] args) {
        int n = 3;
        int k = 9;
        String ans = getHappyString(n,k);
        System.out.println(ans);
    }
}
