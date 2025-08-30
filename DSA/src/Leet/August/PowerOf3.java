package Leet.August;

public class PowerOf3 {
    public static void main(String[] args) {
        int n=3;
        System.out.println(isPowerOfThree(n));
    }
    static boolean isPowerOfThree(int n){
        if (n<1){
            return false;
        }
        if (n%3==0){
            while (n%3==0){
                n=n/3;
            }
            return ((n-1)==0);
        }
        return false;
    }
}
