package Leet.Contest;


/*

You are given an integer n.
Return true if its binary representation contains exactly one adjacent pair of set bits, and false otherwise.

Example 1:
Input: n = 6
Output: true
Explanation:
Binary representation of 6 is 110.
There is exactly one adjacent pair of set bits ("11"). Thus, the answer is true

Example 2:
Input: n = 5
Output: false
Explanation:
Binary representation of 5 is 101.
There is no adjacent pair of set bits. Thus, the answer is false


Constraints:
0 <= n <= 105

 */
public class OnePair {
    public static void main(String[] args) {
        int n = 6;

        System.out.println(consecutiveSetBit(n));
    }

    static boolean consecutiveSetBit(int n){
        int count = 0;
        int prevBit = 0;

        while (n > 0){
            int currentBit = n & 1;

            if (currentBit == 1 && prevBit == 1){
                count++;
            }

            prevBit = currentBit;
            n >>= 1;
        }

        return count == 1;
    }
}
