package Leet.March;

/*
Input: n = 91
Output: true
Explanation: 91 = 3^0 + 3^2 + 3^4

Input: n = 21
Output: false
 */
public class Sum_PowerOf3 {
    public static void main(String[] args) {
        int n=93;
        boolean ans = checkPowerOfThree(n);
        System.out.println(ans);
    }
    static boolean checkPowerOfThree(int n){
        if (n==2){
            return false;
        }

        while (n>0){
           int ans = fun(n,3);
            if (n>=ans){
                n-=ans;
            }
            if (n>=ans){
                return false;
            }
        }
        return true;
    }
    static int fun(int n, int k){
        while(n>=k){
            k*=3;
        }
        k/=3;
        return k;
    }
}


/*
  int power = 0;

        // Find the largest power that is smaller or equal to n
        while (Math.pow(3, power) <= n) {
            power++;
        }

        while (n > 0) {
            // Subtract current power from n
            if (n >= Math.pow(3, power)) {
                n -= (int) Math.pow(3, power);
            }
            // We cannot use the same power twice
            if (n >= Math.pow(3, power)) {
                return false;
            }
            // Move to the next lower power
            power--;
        }

        // n has reached 0
        return true;
 */
