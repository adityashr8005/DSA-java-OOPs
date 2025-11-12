package DSA_Kunal.GraphByApna.Questions;

public class NumOfIsland {

    public static int numsIsland(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j,m,n);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid, int r, int c, int row, int col){

        if (r>=row || c>=col || r<0 || c<0 || grid[r][c] != '1'){
            return;
        }
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
