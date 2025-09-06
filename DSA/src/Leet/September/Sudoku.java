package Leet.September;

public class Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'1','.','.','.','.','.','.','.','.'}
        };

        solveSudoku(board);

    }
    static void solveSudoku(char[][] board){

        if (solve(board)){
            display(board);
        }else {
            System.out.println("Sudoku not solved.");
        }
    }

    static boolean solve(char[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean isEmpty=true;

        for (int i=0; i<n; i++){
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='.'){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }
            if (!isEmpty){
                break;
            }
        }
        if (isEmpty){
            return true;
        }

        //Backtracking
        for (char num='1'; num<='9'; num++){
            if (isSafe(board,row,col,num)){
                board[row][col]=num;
                if (solve(board)){
                    return true;
                }else {
                    board[row][col]='.';
                }
            }
        }
        return false;
    }

    static void display(char[][] board){
        for (char[] row:board){
            for (char cha:row){
                System.out.print(cha+" ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(char[][] board,int row, int col, char num){
        //Check row
        for (int i=0; i< board.length; i++){
            if (board[row][i]==num){
                return false;
            }
        }
        //Check col
        for (char[] chars : board) {
            if (chars[col] == num) {
                return false;
            }
        }

        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;

        for (int r=rowStart; r<rowStart+sqrt; r++){
            for (int c=colStart; c<colStart+sqrt; c++){
                if (board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
