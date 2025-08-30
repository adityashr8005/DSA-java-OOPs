package Leet.August;

public class Power {
    public static void main(String[] args) {
        int n=21;
        System.out.println(isPower(n));
    }
    static boolean isPower(int n){
        if (n<1){
            return false;
        }
        return (n & (n-1))==0;
    }
}
