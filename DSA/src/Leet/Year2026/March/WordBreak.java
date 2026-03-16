package Leet.Year2026.March;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
Given a string s and a dictionary of strings wordDict,
return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
 */

public class WordBreak {

    public static boolean wordBreak(String s, List<String> list){
        Set<String> set = new HashSet<>(list);

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        int maxLength = 0;
        for (String word : set){
            maxLength = Math.max(maxLength,word.length());
        }

        for (int i=1; i<=n; i++){
            for (int j=i-1; j>=Math.max(0,i-maxLength); j--){
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        String s = "applepenappl";
        List<String> list = Arrays.asList("apple", "pen");

        boolean ans = wordBreak(s, list);
        System.out.println(ans);
    }
}
