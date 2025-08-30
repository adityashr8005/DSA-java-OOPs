package Leet.August;

import java.util.Arrays;

public class Sorted2D {
    public static void main(String[] args) {
        int[][] arr = {
                {1,1},
                {2,2}
        };
        int target = 3;
        int[] ans = search(arr,target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){

        //Searching of a target element
        while (cStart<=cEnd){
            int mid = (cStart + cEnd) /2;
            if (matrix[row][mid]==target){
                return new int[] {row,mid};
            }
            if (matrix[row][mid]>target){
                cEnd = mid-1;
            }else{
                cStart = mid+1;
            }
        }
        return new int[] {-1,-1};
    }

    static int[] search(int[][] matrix, int target){
        int row = matrix.length;
        int cols = matrix[0].length;

        if (row==1){
            return binarySearch(matrix,0,0,cols-1,target);
        }
        // Only one column → do vertical binary search
        if (cols == 1) {
            int top = 0, bottom = row-1;
            while (top <= bottom) {
                int mid = top + (bottom - top) / 2;
                if (matrix[mid][0] == target) return new int[]{mid, 0};
                if (matrix[mid][0] > target) bottom = mid - 1;
                else top = mid + 1;
            }
            return new int[]{-1, -1};
        }

        int rStart = 0;
        int rEnd = row-1;
        int cMid = cols/2;

        //Run the loop till two rows are remaining
        while (rStart < (rEnd-1)){
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid]==target){
                return new int[]{mid,cMid};
            }
            if (matrix[mid][cMid] < target){
                rStart = mid;
            }else {
                rEnd = mid;
            }
        }

        //Now we have 2 rows
        if (matrix[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }
        if (matrix[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }

        //1st half searching
        if (target <= matrix[rStart][cMid-1]){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }
        // 2nd half
        if (cMid<cols-1 && target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }
        // 3rd half
        if (target <= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        }
        else {
        //4th half searching
            return binarySearch(matrix,rStart+1, cMid-1,cols-1,target);
        }
    }
}
