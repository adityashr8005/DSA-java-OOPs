package Leet.Year2026.March;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
You are given a string s consisting of lowercase English letters.
A substring of s is called balanced if all distinct characters in the substring appear the same number of times.
Return the length of the longest balanced substring of s.

Example 1:
Input: s = "abbac"
Output: 4
Explanation:
The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.

Example 2:
Input: s = "zzabccy"
Output: 4
Explanation:
The longest balanced substring is "zabc" because the distinct characters 'z', 'a', 'b', and 'c' each appear exactly 1 time.​​​​​​​

Example 3:
Input: s = "aba"
Output: 2
Explanation:
One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time.
Another longest balanced substring is "ba".

Constraints:
1 <= s.length <= 1000
s consists of lowercase English letters.
 */
public class LonestBalancedString {

    public static int longestBalanced(String s){
        int n = s.length();

        int maxCount = 0;
        for (int i=0; i<n; i++){
            int[] arr = new int[26];
            for (int j=i; j<n; j++){
                arr[s.charAt(j) - 'a']++;

                if(checkBalance(arr)){
                    maxCount = Math.max(maxCount,j-i+1);
                }
            }
        }
        return maxCount;
    }

    private static boolean checkBalance(int[] arr) {
        int count = 0;

        for (int i=0; i<arr.length; i++){
            if (arr[i] == 0) continue;

            if (count == 0){
                count = arr[i];
            } else if (arr[i] != count) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "zzabccy";
        int ans = longestBalanced(s);
        System.out.println(ans);
    }
}
