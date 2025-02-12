package Leet.OO1;

public class Reverse_Int {
    public static void main(String[] args) {

        int x = -2147483648;
        int ans = reverse(x);
        System.out.println(ans);
    }
    static int reverse(int x){
        int k=1;
        if (x<0){
            x*=-1;
            k*=-1;
        }
        int sum=0;
        while (x!=0){
            int rem=x%10;
            if(sum > (Integer.MAX_VALUE-rem)/10 ){
                return 0;
            }
            sum = sum*10 + rem;
            x=x/10;
        }
        return sum*k;
    }
}
