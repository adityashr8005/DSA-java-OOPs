package Leet.OO2;

import java.util.Arrays;

/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 */
public class Rotate_String {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        boolean ans = rotateString(s,goal);
        System.out.println(ans);
        char[] arrr={'1','2','3'};
        String n = new String(arrr);
        System.out.println(n);
    }
    static boolean rotateString(String s, String goal){
        int len = s.length();
        if (len != goal.length()){
            return false;
        }
        if (s.equals(goal)){
            return true;
        }
        char[] arr = s.toCharArray();
        for (int i=0; i<len; i++){
            arr = rotateOnce(arr);
            if (new String(arr).equals(goal)){
                return true;
            }
        }
        return false;
    }
    static char[] rotateOnce(char[] arr){
        char temp=arr[0];
        System.arraycopy(arr,1,arr,0,arr.length-1);
        arr[arr.length-1]=temp;
        return arr;
    }
}
