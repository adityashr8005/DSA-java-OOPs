package Leet.OO1;

public class Palindrome {
    public static void main(String[] args) {
        int x  = 1001;
        boolean ans = isPalindrome(x);
        System.out.println(ans);
    }
    static boolean isPalindrome(int x){
        if (x<0){
            return false;
        }
        int num = x;
        int sum = 0;
        while (x>0){
            int rem = x%10;
            sum = sum*10 + rem;
            x=x/10;
        }
        if (num==sum){
            return true;
        }
        return false;
    }
}
