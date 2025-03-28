package Leet.March;

import java.util.Hashtable;

/*
Example 1:

Input: word = "aeioqq", k = 1
Output: 0
Explanation:
There is no substring with every vowel.
----------------------------------------
Example 2:

Input: word = "aeiou", k = 0
Output: 1
Explanation:
The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".
----------------------------------------------------------------------------------------
Example 3:

Input: word = "ieaouqqieaouqq", k = 1
Output: 3
Explanation:
The substrings with every vowel and one consonant are:
word[0..5], which is "ieaouq".
word[6..11], which is "qieaou".
word[7..12], which is "ieaouq".
 */
public class CountSubstringVowel {
    public static void main(String[] args) {
        String word = "iqeaouqi";
        int k=2;
        long ans = countOfSubStrings(word, k);
        System.out.println(ans);
    }
    static long countOfSubStrings(String word, int k){
        Hashtable<String,Boolean> h = new Hashtable<>();

        int count1;
        int count2=0;
        for (int i=0; i<=word.length()-(5+k); i++){

            int end=word.length();
            while ((5+k)<=end) {
                h.put("a",false);
                h.put("e",false);
                h.put("i",false);
                h.put("o",false);
                h.put("u",false);
                count1=0;
                for (int j = i; j < end; j++) {
                    if (word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i' || word.charAt(j) == 'o' || word.charAt(j) == 'u') {
                        h.put(String.valueOf(word.charAt(j)), true);
                    } else {
                        count1++;
                    }
                }
                if (!h.contains(false) && k == count1) {
                    count2++;
                }
                end--;
            }
        }
        return count2;
    }
}
