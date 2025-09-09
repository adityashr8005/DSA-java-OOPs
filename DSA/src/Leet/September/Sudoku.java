package Leet.September;

public class Sudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'1','2','3','4','.','.'},
                {'.','.','.','.','.','.'},
                {'.','3','4','5','6','.'},
                {'.','.','.','.','.','.'},
                {'.','.','2','3','4','5'},
                {'.','.','.','.','.','.'}

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
        for (char num='1'; num<='6'; num++){
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

//        int sqrt = (int)Math.sqrt(board.length);
//        int sqrt = 3;
        int rowStart = row - row%2;
        int colStart = col - col%3;

        for (int r=rowStart; r<rowStart+2; r++){
            for (int c=colStart; c<colStart+3; c++){
                if (board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
