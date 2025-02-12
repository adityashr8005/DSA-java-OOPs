package Leet.OO1;

//Example 1:
//Input: s = "the sky is blue"
//Output: "blue is sky the"

//Example 2:
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing spaces.

//Example 3:
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWord {
    public static void main(String[] args) {
        String s = "the sky is    blue";
        String[] ss = s.split(" ");
        System.out.println(Arrays.toString(ss));
        List<String> word = Arrays.asList(ss);
        Collections.reverse(word);
        System.out.println(word);

        System.out.println(word);
        String output = String.join(" ",word);
        System.out.println(output);

    }
}
