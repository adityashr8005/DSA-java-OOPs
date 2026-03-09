package Leet.Year2026.March;

/*
You are given a string s consisting only of the characters '0' and '1'.
In one operation, you can change any '0' to '1' or vice versa.
The string is called alternating if no two adjacent characters are equal.
For example, the string "010" is alternating, while the string "0100" is not.
Return the minimum number of operations needed to make s alternating.


Example 1:
Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.

Example 2:
Input: s = "10"
Output: 0
Explanation: s is already alternating.

Example 3:
Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010".
 */
public class minimumChange {

    public static int minOperations(String s){
        int n = s.length();
        int i = 0;

        int flip1 = 0, flip2 = 0;

        while (i<n){
            char expected1 = (i%2 == 0) ? '0' : '1';
            char expected2 = (i%2 == 0) ? '1' : '0';
            if (s.charAt(i) != expected1){
                flip1++;
            }
            if (s.charAt(i) != expected2){
                flip2++;
            }
            i++;
        }
        return Math.min(flip1,flip2);
    }

    public static void main(String[] args) {
        String s = "1111";
        int ans = minOperations(s);
        System.out.println(ans);
    }
}

