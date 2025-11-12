package Leet.November;

import java.util.LinkedList;
import java.util.Queue;

/*
 You are given an m x n grid where each cell can have one of three values:
 ● 0 representing an empty cell,
 ● 1 representing a fresh orange, or
 ● 2 representing a rotten orange.
 Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange
 becomes rotten.

 Return the minimum number of minutes that must elapse until no cell has a fresh
 orange. If this is impossible, return -1.

 Example 1
 Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 Output: 4

 Example 2
 Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 Output: -1
 Explanation: The orange in the bottom left corner (row 2, column 0) is never
 rotten, because rotting only happens 4-directionally.
 */

public class RottenOrange {

    public static int rottingOrange(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        //Copying array grid  to  array vis.
//        int[][] vis = grid;
        ///   OR,
        int[][] vis = new int[grid.length][];
        for (int i=0; i<grid.length; i++){
            vis[i] = new int[grid[i].length];
            System.arraycopy(grid[i],0,vis[i],0,grid[i].length);
            /*
            System.arraycopy(sourceArray, sourceStartIndex,
                             destinationArray, destinationStartIndex,
                             numberOfElementsToCopy);
            */
        }

        int freshOrange = 0;

        //Initialized queue for array type.
        Queue<int[]> q = new LinkedList<>();

        //Traverse all element of matrix
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){

                //Add index to queue if equals to 2
                if (grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                //Increment freshOrange count if found 1->fresh Orange
                if (grid[i][j]==1){
                    freshOrange++;
                }
            }
        }

        //Check edge cases
        if (freshOrange == 0){
            return 0;
        }
        if (q.isEmpty()){
            return -1;
        }

        int min = -1; //Initialized minutes.
        //Made 2D array to implement all four direction
        int[][] direction = {
                {1,0}, // Down row+
                {-1,0},// Up row-
                {0,-1},// Left col-
                {0,1}  // Right col+
        };

        //Putted extra while to increment min for every rottenOperation.
        while (!q.isEmpty()){
            int size = q.size();
            while (size-- > 0){
                //Inserted rottenOrange index into array cell[]
                int[] cell = q.poll();

                int x = cell[0]; // if cell[] -> {0,1} x=0 and y=1
                int y = cell[1];

                //Loop for checking all four direction for rottenOrange position.
                for (int[] dir : direction){
                    int i = x + dir[0]; // dir[] {1,0}down - then i = x + 1 && j = y + 0
                    int j = y + dir[1];

                    //check for existed index && (visited element == 1)
                    if (i>=0 && j>= 0 && i<m && j<n && vis[i][j]==1){
                        vis[i][j] = 2;
                        freshOrange--;
                        q.offer(new int[]{i,j});
                    }
                }
            }
            min++;
        }

        //if all freshOrange rotten return min(Minutes)...
        if (freshOrange == 0){
            return min;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(rottingOrange(matrix));
    }
}
