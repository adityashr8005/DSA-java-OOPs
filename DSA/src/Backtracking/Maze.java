package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        boolean[][] arr={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        String p = "";
        int[][] steps = new int[arr.length][arr[0].length];
        List<String> ans = allPath(p,arr,0,0,1,steps);
        System.out.println(ans);
    }
    static List<String> path(String p, boolean[][] arr, int row, int col){
        if (row==arr.length-1 && col==arr[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (!arr[row][col]) {
            return list;
        }

        if (row<arr.length-1){
            list.addAll(path(p+'D',arr,row+1,col));
        }
        if (col<arr[0].length-1){
            list.addAll(path(p+'R',arr,row,col+1));
        }
        return list;
    }

    static List<String> allPath(String p, boolean[][] arr, int row, int col,int step, int[][] steps){
        steps[row][col]=step;
        if (row==arr.length-1 && col==arr[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            for (int[] ways:steps){
                System.out.println(Arrays.toString(ways));
            }
            System.out.println(p);
            System.out.println();
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (!arr[row][col]) {
            return list;
        }
        arr[row][col]=false;
        steps[row][col]=step;

        if (row<arr.length-1){
            list.addAll(allPath(p+'D',arr,row+1,col,step+1,steps));
        }
        if (col<arr[0].length-1){
            list.addAll(allPath(p+'R',arr,row,col+1,step+1,steps));
        }
        if (row>0){
            list.addAll(allPath(p+'U',arr,row-1,col,step+1,steps));
        }
        if (col>0){
            list.addAll(allPath(p+'L',arr,row,col-1,step+1,steps));
        }
        arr[row][col]=true;
        steps[row][col]=0;
        return list;
    }
}
