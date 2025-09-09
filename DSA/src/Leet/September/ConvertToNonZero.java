package Leet.September;

import java.util.Arrays;

/*
Example 1:
Input: n = 2
Output: [1,1]
Explanation: Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.

Example 2:
Input: n = 11
Output: [2,9]
Explanation: Let a = 2 and b = 9.
Both a and b are no-zero integers, and a + b = 11 = n.
Note that there are other valid answers as [8, 3] that can be accepted.

 */
public class ConvertToNonZero {
    public static void main(String[] args) {
        int num=1010;
        System.out.println(Arrays.toString(getNoZeroInteger(num)));
    }
    static int[] getNoZeroInteger(int n){
        int[] arr =new int[2];
        int i,j=n-1;
        for (i=1; i<=j;) {
            if (!isSafe(i,j)) {
                i++;
                j--;
            }else {
                break;
            }
        }
        arr[0]=i;
        arr[1]=j;

        return arr;
    }
    static boolean isSafe(int i, int j){
        int rem=0;
        while (i>0){
            rem=i%10;
            if (rem==0){
                return false;
            }
            i=i/10;
        }
        while (j>0){
            rem=j%10;
            if (rem==0){
                return false;
            }
            j=j/10;
        }
        return true;
    }
}
