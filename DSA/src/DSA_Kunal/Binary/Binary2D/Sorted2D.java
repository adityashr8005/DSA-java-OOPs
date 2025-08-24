package DSA_Kunal.Binary.Binary2D;

import java.util.Arrays;

public class Sorted2D {
    public static void main(String[] args) {
        int[][] arr = {
                {1},
                {3}
        };
        int target = 0;
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

    static int[] search(int[][] arr, int target){
        int row = arr.length;
        int cols = arr[0].length;

        if (row==1){
            return binarySearch(arr,0,0,cols-1,target);
        }

        int rStart = 0;
        int rEnd = row-1;
        int cMid = cols/2;
        //Run the loop till two rows are remaining
        while (rStart < (rEnd-1)){
            int mid = rStart + rEnd /2;
            if (arr[mid][cMid]==target){
                return new int[]{mid,cMid};
            }
            if (arr[mid][cMid] < target){
                rStart = mid;
            }else {
                rEnd = mid;
            }
        }

        //Now we have 2 rows
        if (arr[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }
        if (arr[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }

        //1st half searching
        if (target <= arr[rStart][cMid-1]){
            return binarySearch(arr,rStart,0,cMid-1,target);
        }
        //2nd half searching
        if (target <= arr[rStart][cMid+1] && target <= arr[rStart][cols-1]){
            return binarySearch(arr,rStart,cMid+1,cols-1,target);
        }
        //3rd half searching
        if (target <= arr[rStart+1][cMid-1]){
            return binarySearch(arr,rStart+1,0,cMid-1,target);
        }else {
        //4th half searching
            return binarySearch(arr,rStart+1, cMid+1,cols-1,target);
        }
    }
}
