package Leet.March;

/*
Example 1:

Input: blocks = "WBBWWBBWBW", k = 7
Output: 3

Explanation:
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
so that blocks = "BBBBBBBWBW".
It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
Therefore, we return 3.
-----------------------------------------------------------------------------------------------------
Example 2:

Input: blocks = "WBWBBBW", k = 2
Output: 0

Explanation:
No changes need to be made, since 2 consecutive black blocks already exist.
Therefore, we return 0.
 */
public class MinimumRecolors {
    public static void main(String[] args) {
        String str = "WBBWWBBWBW";
        int k=7;
        int ans = minimumRecolors(str,k);
        System.out.println(ans);
    }
    static int minimumRecolors(String blocks, int k){
        boolean check=true;
        int count1;
        int count2=0;
        for (int i=0; i<=blocks.length()-k; i++){
            count1=0;
            for (int j=i; j<(i+k); j++) {
                if (blocks.charAt(j) == 'W') {
                    count1++;
                }
            }
            if (count1==0){
                return 0;
            }

            if (count1<count2){
                count2=count1;
            } else if (check) {
                count2=count1;
                check=false;
            }
        }
        return count2;
    }
}
