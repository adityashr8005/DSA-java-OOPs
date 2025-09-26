package Leet.September;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortedArr {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(num1, m, num2, n);
    }

    static void merge(int[] num1, int m, int[] num2, int n){
//        int j = 0;
//        for (int i= m ; i< num1.length; i++){
//            num1[i] = num2[j++];
//        }
//
//        Arrays.sort(num1);
//        System.out.println(Arrays.toString(num1));

        //Optimised solution.
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while (i>=0 && j>=0){
            if (num1[i]>num2[j]){
                num1[k--] = num1[i--];
            }else {
                num1[k--] = num2[j--];
            }
        }

        while (j>=0){
            num1[k--] = num2[j--];
        }
        System.out.println(Arrays.toString(num1));
    }
}
