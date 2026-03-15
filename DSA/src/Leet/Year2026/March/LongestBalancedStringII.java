package Leet.Year2026.March;


import java.util.HashMap;

/*
You are given a string s consisting only of the characters 'a', 'b', and 'c'.
A substring of s is called balanced if all distinct characters in the substring appear the same number of times.
Return the length of the longest balanced substring of s.

Example 1:
Input: s = "abbac"
Output: 4
Explanation:
The longest balanced substring is "abba" because both distinct characters 'a' and 'b' each appear exactly 2 times.

Example 2:
Input: s = "aabcc"
Output: 3
Explanation:
The longest balanced substring is "abc" because all distinct characters 'a', 'b' and 'c' each appear exactly 1 time.

Example 3:
Input: s = "aba"
Output: 2
Explanation:
One of the longest balanced substrings is "ab" because both distinct characters 'a' and 'b' each appear exactly 1 time. Another longest balanced substring is "ba".

Constraints:
1 <= s.length <= 105
s contains only the characters 'a', 'b', and 'c'.
 */
public class LongestBalancedStringII {

    public static int helper(String s, char ch1, char ch2){
        int n = s.length();
        int count1 = 0;
        int count2 = 0;
        int max = 0;

        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,i-1);

        for ( i=0; i<n; i++){
            if (s.charAt(i) != ch1 && s.charAt(i) != ch2){
                map.clear();
                count1 = 0;
                count2 = 0;
                continue;
            }

            if (s.charAt(i) == ch1){
                count1++;
            }
            if (s.charAt(i) == ch2){
                count2++;
            }

            if (count1 == count2){
                max = Math.max(max,count1+count2);
            }

            int difference = count1 - count2;

            if (map.containsKey(difference)){
                max = Math.max(max, i - map.get(difference));
            }else {
                map.put(difference, i);
            }
        }
        return max;
    }

    public static int longestBalancedII(String s){
        int n = s.length();
        int max = 0;

        //Case I.
        int count = 1;
        for (int i=1; i<n; i++){
            if (s.charAt(i) == s.charAt(i-1)){
                count++;
            } else {
                max = Math.max(max,count);
                count = 1;
            }
        }
        max = Math.max(max,count);

        //Case II
        max = Math.max(max,helper(s, 'a', 'b'));
        max = Math.max(max,helper(s, 'a', 'c'));
        max = Math.max(max,helper(s, 'b', 'c'));

        //Case III
        int i = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("0-0", i-1);
        int countA = 0;
        int countB = 0;
        int countC = 0;

        for ( i=0; i<n; i++){
            if (s.charAt(i) == 'a') countA++;
            if (s.charAt(i) == 'b') countB++;
            if (s.charAt(i) == 'c') countC++;

            if (countA == countB && countB == countC){
                max = Math.max(max, countA+countB+countC);
            }

            int differenceAB = countA - countB;
            int differenceAC = countA - countC;

            String key = Integer.toString(differenceAB) + "-" + Integer.toString(differenceAC);

            if (map.containsKey(key)){
                max = Math.max(max, i - map.get(key));
            }else {
                map.put(key, i);
            }
        }

        return max;
    }
    public static void main(String[] args) {
        String s = "ccac";
        int ans = longestBalancedII(s);
        System.out.println(ans);
    }
}

















/*
class Solution {
    public int longestBalanced(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        int cur_a = 0, cur_b = 0, cur_c = 0;
        int max_a = 0, max_b = 0, max_c = 0;

        for (int i = 0; i < n; i++) {
            if (c[i] == 'a') {
                cur_a = (i > 0 && c[i-1] == 'a') ? cur_a + 1 : 1;
                max_a = Math.max(max_a, cur_a);
            } else if (c[i] == 'b') {
                cur_b = (i > 0 && c[i-1] == 'b') ? cur_b + 1 : 1;
                max_b = Math.max(max_b, cur_b);
            } else {
                cur_c = (i > 0 && c[i-1] == 'c') ? cur_c + 1 : 1;
                max_c = Math.max(max_c, cur_c);
            }
        }

        int res = Math.max(Math.max(max_a, max_b), max_c);

        res = Math.max(res, find2(c, 'a', 'b'));
        res = Math.max(res, find2(c, 'a', 'c'));
        res = Math.max(res, find2(c, 'b', 'c'));

        res = Math.max(res, find3(c));

        return res;
    }

    private int find2(char[] c, char x, char y) {
        int n = c.length, max_len = 0;
        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int clear_idx = -1, diff = n;
        first[diff] = -1;

        for (int i = 0; i < n; i++) {
            if (c[i] != x && c[i] != y) {
                clear_idx = i;
                diff = n;
                first[diff] = clear_idx;
            } else {
                if (c[i] == x) diff++;
                else diff--;

                if (first[diff] < clear_idx) {
                    first[diff] = i;
                } else {
                    max_len = Math.max(max_len, i - first[diff]);
                }
            }
        }

        return max_len;
    }

    private int find3(char[] c) {
        long state = Long.MAX_VALUE / 2;
        Map<Long, Integer> first = new HashMap<>();
        first.put(state, -1);

        int max_len = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a') state += 1_000_001;
            else if (c[i] == 'b') state -= 1_000_000;
            else state--;

            if (first.containsKey(state)) {
                max_len = Math.max(max_len, i - first.get(state));
            } else {
                first.put(state, i);
            }
        }

        return max_len;
    }
}
 */