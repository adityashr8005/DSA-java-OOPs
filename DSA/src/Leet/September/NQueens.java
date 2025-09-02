package Leet.September;

public class NQueens {
    public static void main(String[] args) {
        int n=1;
        boolean[][] board = new boolean[n][n];
        System.out.println("All the combination possible");
        System.out.println("Total number of combination:"+queen(board,0));
    }
    static int queen(boolean[][] board, int row){
        if (row==board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;

        for (int col=0; col<board.length;col++){
            if (isSafe(board,row,col)){
                board[row][col]=true;
                count += queen(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        //Check the upper row
        for (int i=0; i<row; i++){
            if (board[i][col]){
                return false;
            }
        }

        //Check left diagonal
        int maxLeft = Math.min(row,col);
        for (int i=1; i<=maxLeft; i++){
            if (board[row-1][col-1]){
                return false;
            }
        }

        //Check right diagonal
        int maxRight = Math.min(row, board.length-1-col);
        for (int i=1; i<=maxRight; i++){
            if (board[row-1][col+1]){
                return false;
            }
        }
        return true;
    }
    static void display(boolean[][] board){
        for (boolean[] row:board){
            for (boolean element:row){
                if (element){
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
