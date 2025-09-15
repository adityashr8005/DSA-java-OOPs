package Leet.September;
/*
Example 1:
Input: text = "hello world", brokenLetters = "ad"
Output: 1
Explanation: We cannot type "world" because the 'd' key is broken.

Example 2:
Input: text = "leet code", brokenLetters = "lt"
Output: 1
Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.

Example 3:
Input: text = "leet code", brokenLetters = "e"
Output: 0
Explanation: We cannot type either word because the 'e' key is broken.
 */

public class WordsTyped {
    public static void main(String[] args) {
        String text = "leet code";
        String brokenLetters = "e";
        System.out.println(canBeTypedWords(text,brokenLetters));
    }
    static int canBeTypedWords(String text, String brokenLetter){
        int count = 0;
        boolean check=false;
        for (int i=0; i<text.length(); i++){
           for (int j=0; j<brokenLetter.length(); j++){
               if (text.charAt(i)==brokenLetter.charAt(j)){
                   check=true;
                   break;
               }
           }
           if (text.charAt(i)==32 && !check){
               count++;
           }
           if (text.charAt(i)==32){
               check = false;
           }
           if (i==text.length()-1 && !check){
               count++;
           }
        }
        return count;
    }
}
