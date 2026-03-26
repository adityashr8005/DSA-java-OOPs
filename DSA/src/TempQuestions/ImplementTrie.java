package TempQuestions;

import java.util.ArrayList;
import java.util.Arrays;

/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and
retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix,
                                  and false otherwise.


Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


Constraints:
1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */
public class ImplementTrie {

    static class Trie{
        Trie[] children;
        boolean eow;

        public Trie(){
            children = new Trie[26];
            eow = false;
        }
    }
    static Trie root = new Trie();

    public static void insert(String word){
        Trie curr = root;
        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null){
                curr.children[index] = new Trie();
            }
            if (i == word.length()-1){
                curr.children[index].eow = true;
            }
            curr = curr.children[index];
        }
    }

    public static boolean search(String word){
        Trie curr = root;
        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';

            Trie node = curr.children[index];

            if (node == null) return false;

            if (i==word.length()-1 && node.eow == false) return false;

            curr = node;
        }
        return true;
    }

    public static boolean startsWith(String prefix){
        Trie curr = root;

        for (int i=0; i<prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';

            Trie node = curr.children[index];

            if (node == null) return false;

            if (i == prefix.length()-1) return true;

            curr = node;
        }

        return false;
    }

    public static void main(String[] args) {

        String[] words = {"", "apple", "apple"};    //, "app", "app", "app", "app"
        String[] commands = {"Trie", "insert", "search", "search", "startWith", "insert", "search"};

        for (String s : words){
            insert(s);
        }

        System.out.println(search("app"));

        System.out.println(startsWith("apple"));
    }
}
