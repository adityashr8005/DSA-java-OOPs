package Leet.November;

/*
 Given an m x n 2D binary grid which represents a map of '1's (land) and '0's
 (water), return the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands
 horizontally or vertically. You may assume all four edges of the grid are all
 surrounded by water.

 Example 1
 Input: grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 Output: 1

 Example 2
 Input: grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 Output: 3
 */

public class NumsIsland {

    public static int numsIsland(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;

        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    island++;
                }
            }
        }
        return island;
    }
    public static void dfs(char[][] grid, int r, int c, int row, int col){

        if (r>=row || c>=col || r<0 || c<0 || grid[r][c] != '1') return;

        grid[r][c] = '0';

        dfs(grid, r+1, c, row, col);
        dfs(grid, r-1, c, row, col);
        dfs(grid, r, c+1, row, col);
        dfs(grid, r, c-1, row, col);
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println(numsIsland(matrix));
    }
}
