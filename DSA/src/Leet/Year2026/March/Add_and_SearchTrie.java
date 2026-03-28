package Leet.Year2026.March;

/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
word may contain dots '.' where dots can be matched with any letter.

Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:
1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 10^4 calls will be made to addWord and search.
 */
public class Add_and_SearchTrie {

    static class Trie {
        Trie[] children;
        boolean eow;

        public Trie(){
            children = new Trie[26];
            eow = false;
        }
    }
    static Trie root = new Trie();

    public static void addWord(String word){
        Trie curr = root;

        for (int i=0; i<word.length(); i++){
            int index = word.charAt(i) - 'a';

            if (curr.children[index] == null){
                curr.children[index] = new Trie();
            }
            if (i==word.length()-1){
                curr.children[index].eow = true;
            }
            curr = curr.children[index];
        }
    }

    public static boolean searchDFS(String word, int i, Trie curr){
        if (curr == null) return false;

        if (i==word.length()) return curr.eow;

        if (word.charAt(i) != '.'){
            int index = word.charAt(i) - 'a';
            return searchDFS(word,i+1,curr.children[index]);
        }

        for (int j=0; j<26; j++){
            if (curr.children[j] != null){
                if (searchDFS(word,i+1,curr.children[j])){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean search(String word){
        Trie curr = root;

        return searchDFS(word,0,curr);
    }

    public static void main(String[] args) {
//        String[] commands = {"WordDictionary","addWord","addWord","addWord","search","search","search","search"};
//        String[][] words = {{},{"bad"},{"dad"},{"mad"},{"pad"},{"bad"},{".ad"},{"b.."}};

        String[] words = {"bad", "dad", "mad"};
        for (String word : words){
            addWord(word);
        }

        System.out.println(search(".ad"));
    }

}
