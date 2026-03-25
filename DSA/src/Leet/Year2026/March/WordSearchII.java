package Leet.Year2026.March;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
 */
public class WordSearchII {

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
            curr = curr.children[index];

            if (i == word.length()-1){
                curr.eow = true;
                curr.word = word;
            }
        }
    }

    static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static void search(char[][] board, int i, int j, Node curr){
        if (i<0 || i>=m || j<0 || j>=n) return ;

        if (board[i][j] == '$' || curr.children[board[i][j] - 'a'] == null) return;

        curr = curr.children[board[i][j] - 'a'];

        if (curr.eow){
            result.add(curr.word);
            curr.eow = false;
        }

        char temp = board[i][j];
        board[i][j] = '$';  //Marking visited;

        for (int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            search(board,new_i,new_j,curr);
        }
        board[i][j] = temp;     //Marking unvisited;
    }

    static ArrayList<String> result;
    static int m;
    static int n;
    public static List<String> findWords(char[][] board, String[] words){
        Node curr = root;
        result = new ArrayList<>();

        m = board.length;
        n = board[0].length;

        for (String s : words){
            insert(s);
        }

        for (int i = 0; i<m; i++){
            for (int j=0; j<n; j++){
                char ch = board[i][j];

                if (curr.children[ch - 'a'] != null){
                    search(board,i,j,curr);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(findWords(board, words));
    }
}
