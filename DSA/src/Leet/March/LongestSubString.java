package Leet.March;

import java.util.HashMap;

/*
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubString {
    public static void main(String[] args) {
        String  str = "dvdf";
        int ans = lengthOfLongestSubstring(str);
        System.out.println(ans);
    }
    static int lengthOfLongestSubstring(String s){
        HashMap<Integer,Character> map = new HashMap<>();
        int max=1;

        for (int i=0; i<s.length(); i++){
            int count=0;
            int j=i;
            while (!map.containsValue(s.charAt(j)) && j<=s.length()-1){
                map.put(j,s.charAt(j));
                if (j==s.length()-1){
                    count++;
                    break;
                }else
                    j++;
                count++;
            }
            if (count>max){
                max=count;
            }
            map.clear();
        }
        return max;
    }
}
