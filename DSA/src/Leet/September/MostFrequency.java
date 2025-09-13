package Leet.September;

import java.util.HashMap;

/*
Example 1:
Input: s = "successes"
Output: 6
Explanation:
The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
The output is 2 + 4 = 6.

Example 2:
Input: s = "aeiaeia"
Output: 3
Explanation:
The vowels are: 'a' (frequency 3), 'e' (frequency 2), 'i' (frequency 2). The maximum frequency is 3.
There are no consonants in s. Hence, maximum consonant frequency = 0.
The output is 3 + 0 = 3.
 */
public class MostFrequency {
    public static void main(String[] args) {
        String s = "successes";
        System.out.println(maxFreqSum(s));
    }
    static int maxFreqSum(String s){
        int[] freq = new int[26];
        int maxV=0, maxC=0;
        for (int i=0; i<s.length(); i++){
            int ch = s.charAt(i);
            int c = s.charAt(i) - 'a';
            freq[c]++;
            if (ch=='a'|| ch=='e'|| ch=='i'|| ch=='o'|| ch=='u'){
                maxV=Math.max(maxV,freq[c]);
            }else {
                maxC=Math.max(maxC,freq[c]);
            }
        }
        return maxV+maxC;
    }
}
