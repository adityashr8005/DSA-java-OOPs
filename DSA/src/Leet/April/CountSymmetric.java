package Leet.April;
/*
Example 1:
Input: low = 1, high = 100
Output: 9
Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.

Example 2:
Input: low = 1200, high = 1230
Output: 4
Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.

Constraints:
1 <= low <= high <= 104
 */

public class CountSymmetric {
    public static void main(String[] args) {
        int low=1200;
        int high=1230;
        System.out.println(countSymmetric(low,high));
    }
    static int countSymmetric(int low, int high){
        int count=0;

        for (int i=low; i<=high; i++){
            int num = convertInteger(i);
            count += num;
        }

        return count;
    }

    static int convertInteger(int num){
        String str = Integer.toString(num);
        if (str.length()%2!=0){
            return 0;
        }
        int sum1=0 , sum2=0;
        int half = str.length()/2;
        for (int i=0; i<half; i++){
            sum1 += str.charAt(i);
            sum2 += str.charAt(half + i);
        }

        if (sum1==sum2){
            System.out.println(str);
            return 1;
        }
        return 0;
    }
}

