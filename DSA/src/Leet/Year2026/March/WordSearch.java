package Leet.Year2026.March;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
Output: false

Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 */

public class WordSearch {

    static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static boolean find(char[][] board, int i, int j, int index, String word){
        if (index == word.length()) return true;

        if (i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j] == '$'){
            return false;
        }

        if (board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '$';

        for (int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if (find(board,new_i,new_j,index+1,word)){
                return true;
            }
        }
        board[i][j] = temp;

        return false;
    }

    public static boolean exist(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (board[i][j] == word.charAt(0) && find(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";

        boolean ans = exist(grid, word);
        System.out.println(ans);
    }
}
