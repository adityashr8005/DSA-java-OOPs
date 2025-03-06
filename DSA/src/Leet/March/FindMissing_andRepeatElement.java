package Leet.March;

import java.util.Arrays;
import java.util.Hashtable;

/*
Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing, so the answer is [2,4].
---------------------------------------------------------------------------------
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing, so the answer is [9,5].
 */
public class FindMissing_andRepeatElement {
    public static void main(String[] args) {
        int[][] matrix={
                {9,1,7},
                {8,9,2},
                {3,4,6}
        };

        int[] ans = function(matrix);
        System.out.println(Arrays.toString(ans));
    }
    static int[] function(int[][] grid){
        Hashtable<Integer,Integer> h = new Hashtable<>();

        int[] ans=new int[2];

        for (int[] integer : grid)
            for (int j = 0; j < grid.length; j++) {
                if (h.get(integer[j]) == null) {
                    h.put(integer[j], integer[j]);
                } else {
                    ans[0] = h.get(integer[j]);
                }
            }

//        for (int i=0; i<grid.length; i++)
//            for (int j = 0; j < grid.length; j++) {
//                if (h.get(grid[i][j]) == null) {
//                    h.put(grid[i][j], grid[i][j]);
//                } else {
//                    ans[0] = h.get(grid[i][j]);
//                }
//            }

        for (int i=1; i<=grid.length * grid.length; i++){
            if (h.get(i)==null){
                ans[1]=i;
            }
        }

        return ans;
    }
}
