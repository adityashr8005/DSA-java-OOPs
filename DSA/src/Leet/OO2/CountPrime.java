package Leet.OO2;
//Prime number less than n
public class CountPrime {
    public static void main(String[] args) {
        int n = 19;
        int ans = countPrimes(n);
        System.out.println(ans);
    }
    static int countPrimes(int n) {
        int count = 0;
        boolean[] prime = new boolean[n+1];
        for (int i = 0; i<n; i++) {
            prime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p*p; i<=n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.println(" " + i);
                count++;
            }
        }
        return count;
    }
}
