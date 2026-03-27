package Leet.Year2026.March;

import java.util.Arrays;
import java.util.List;

/*
In English, we have a concept called root, which can be followed by some other word to form another longer word
- let's call this word derivative. For example, when the root "help" is followed by the word "ful",
we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root,
replace it with the root that has the shortest length.

Return the sentence after the replacement.

Example 1:
Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Example 2:
Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"

Constraints:
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case letters.
1 <= sentence.length <= 106
 • sentence consists of only lower-case letters and spaces.
 • The number of words in sentence is in the range [1, 1000]
 • The length of each word in sentence is in the range [1, 1000]
 • Every two consecutive words in sentence will be separated by exactly one space.
 • sentence does not have leading or trailing spaces.
 */
public class ReplaceWords {

    static class Node{
        Node[] children;
        boolean eow;
        String word;

        public Node(){
            children = new Node[26];
            eow = false;
            word = "";
        }
    }
    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;

        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null){
                curr.children[index] = new Node();
            }
            if (i == word.length()-1){
                curr.children[index].eow = true;
                curr.children[index].word = word;
            }
            curr = curr.children[index];
        }
    }

    public static String  search(String word){
        Node curr = root;

        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';
            Node node = curr.children[index];

            if (node == null) return word;

            if (node.eow){
                return node.word;
            }
            curr = node;
        }
        return word;
    }

    public static String replaceWords(List<String> dictionary, String sentence){
        StringBuilder result = new StringBuilder();

        //Splitting the sentence into words and store in words[]
        String[] words = sentence.split(" ");

        //Inserting all the prefixes to trie
        for (String list : dictionary){
            insert(list);
        }

        //searching each word of sentence
        for (String word : words){
            String returnWord = search(word);
            if (!result.isEmpty()){
                result.append(" ");
            }
            result.append(returnWord);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";

        System.out.println(replaceWords(list,sentence));
    }
}
