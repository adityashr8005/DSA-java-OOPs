package Leet.Year2026.March;

/*
You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:

Type-1: Remove the character at the start of the string s and append it to the end of the string.
Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice versa.
Return the minimum number of type-2 operations you need to perform such that s becomes alternating.

The string is called alternating if no two adjacent characters are equal.

For example, the strings "010" and "1010" are alternating, while the string "0100" is not.

Example 1:
Input: s = "111000"
Output: 2
Explanation: Use the first operation two times to make s = "100011".
Then, use the second operation on the third and sixth elements to make s = "101010".

Example 2:
Input: s = "010"
Output: 0
Explanation: The string is already alternating.

Example 3:
Input: s = "1110"
Output: 1
Explanation: Use the second operation on the second element to make s = "1010".
 */

public class MinimumFlips {

    public static int minFlips(String s){
        int n = s.length();
//        s = s + s;
//        String s1 = "", s2 = "";
//
//        for (int i=0; i<2*n; i++){
//           s1 += (i%2 == 0) ? "0" : "1";
//            s2 += (i%2 == 0) ? "1" : "0";
//        }

        int i=0, j=0;
        int flipA = 0, flipB = 0;
        int result = Integer.MAX_VALUE;


        while (j<2*n){
            String expectedS1 = (j%2 == 0) ? "0" : "1";
            String expectedS2 = (j%2 == 0) ? "1" : "0";

            if (s.charAt(j%n) != expectedS1.charAt(0)){
                flipA++;
            }
            if (s.charAt(j%n) != expectedS2.charAt(0)){
                flipB++;
            }

            if (j-i+1 >n){
                String expS1 = (i%2 == 0) ? "0" : "1";
                String expS2 = (i%2 == 0) ? "1" : "0";
                if (s.charAt(i) != expS1.charAt(0)){
                    flipA--;
                }
                if ((s.charAt(i) != expS2.charAt(0))){
                    flipB--;
                }
                i++;
            }
            if (j-i+1 == n){
                int min = Math.min(flipA,flipB);
                result = Math.min(result,min);
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "01001001101";
        int ans = minFlips(s);
        System.out.println(ans);
    }
}

/*
0100100110101001001101

0101010101010101010101
1010101010101010101010
 */