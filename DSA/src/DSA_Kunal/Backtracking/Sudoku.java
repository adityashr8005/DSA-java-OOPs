package DSA_Kunal.Backtracking;

public class Sudoku {
    public static void main(String[] args) {

        int[][] board = new int[][]{
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        if (solve(board)){
            display(board);
        }else {
            System.out.println("Sudoku not solved");
        }
    }

    static boolean solve(int[][] board){
        int n= board.length;
        int row=-1;
        int col=-1;

        boolean isEmpty=true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]==0){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }
            //If any empty is found
            if (!isEmpty){
                break;
            }
        }
        if (isEmpty){
            return true;
        }

        //Backtrack
        for (int num=1; num<=9; num++){
            if (isSafe(board,row,col,num)){
                board[row][col]=num;
                if (solve(board)){
                    return true;
                    //sudoku solved
                }else {
                    board[row][col]=0;
                }
            }
        }
        return false;
    }

    static void display(int[][] board){
        for (int[] row:board){
            for (int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        //Check for row
        for (int i=0; i< board.length; i++){
            //check if num is in the row
            if (board[row][i]==num){
                return false;
            }
        }

        //Check for col
        for (int i=0; i< board.length; i++){
            if (board[i][col]==num){
                return false;
            }
        }

        //Check for box
        int value = (int)Math.sqrt(board.length);
        int rowStart = row - row%value;
        int colStart = col - col%value;

        for (int r=rowStart; r<rowStart+value; r++){
            for (int c=colStart; c<colStart+value; c++){
                if (board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
