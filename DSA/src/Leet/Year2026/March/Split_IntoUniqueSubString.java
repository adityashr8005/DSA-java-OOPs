package Leet.Year2026.March;

/*
Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string.
However, you must split the substrings such that all of them are unique.
A substring is a contiguous sequence of characters within a string.

Example 1:
Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc'].
Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.

Example 2:
Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].

Example 3:
Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.

Constraints:
1 <= s.length <= 16
s contains only lower case English letters.
 */
import java.util.HashSet;

public class Split_IntoUniqueSubString {

    public static int solve(String s, int i, int count, int max, HashSet<String> set){

        if (i >= s.length()){
            max = Math.max(max,count);
            return max;
        }
        for (int j=i; j<s.length(); j++){
            String subString = s.substring(i, j+1);
            if (!set.contains(subString)){
                set.add(subString);
                max = solve(s,j+1,count+1,max,set);
                set.remove(subString);
            }
        }
        return max;
    }

    public static int maxUniqueSplit(String s){

        HashSet<String> set = new HashSet<>();
        int i = 0;
        int count = 0;
        int max = 0;

        max = solve(s, i, count, max , set);

        return max;
    }

    public static void main(String[] args) {
        String s = "abaccc";
        int ans = maxUniqueSplit(s);
        System.out.println(ans);
    }
}
