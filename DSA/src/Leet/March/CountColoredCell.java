package Leet.March;

/*
Example 1:

Input: n = 1
Output: 1
Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
-------------------------------------------------------------------------
Example 2:

Input: n = 2
Output: 5
Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5.
 */
public class CountColoredCell {
    public static void main(String[] args) {
        long n=69675;
        long ans = coloredCell(n);
        System.out.println(ans);
        System.out.println(Math.pow(n,2)+(Math.pow(n-1,2)));
    }
    static long coloredCell(long n){
        //1  5  13  25  41  61  ..
        if (n==1){
            return 1;
        }
        long k=1;
        for (long i=1; i<n; i++){
            k=(i*4)+k;
        }
        long l = (long)(Math.pow(n,2)+(Math.pow(n-1,2)));
        return k;
        //return k or l both method gives same answer.
    }
}
