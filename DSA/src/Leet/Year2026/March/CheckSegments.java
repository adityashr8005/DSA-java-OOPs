package Leet.Year2026.March;

/*
Given a binary string s without leading zeros, return true  if s contains at most one contiguous segment of ones.
Otherwise, return false.

Example 1:
Input: s = "1001"
Output: false
Explanation: The string has two segments of size 1.

Example 2:
Input: s = "110"
Output: true
 */
public class CheckSegments {

    public static boolean checkOneSegment(String s){
        return !s.contains("01");
    }

    public static void main(String[] args) {
        String s = "1110001";
        boolean ans = checkOneSegment(s);
        System.out.println(ans);
    }
}
