package Leet.March;

/*
Example 1:

Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.
-----------------------------------------------------------------------------------
Example 2:

Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class ClosestPrime {
    public static void main(String[] args) {
        int left = 19;
        int right = 31;
        int[] ans = closestPrime(left,right);
        System.out.println(Arrays.toString(ans));
    }
    static int[] closestPrime(int left, int right){
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    prime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minGap = Integer.MAX_VALUE;
        int[] mat = {-1, -1};

        for (int i = 1; i < primes.size(); i++) {
            int gap = primes.get(i) - primes.get(i - 1);
            if (gap < minGap) {
                minGap = gap;
                mat[0] = primes.get(i - 1);
                mat[1] = primes.get(i);
            }
        }

        return mat;



//        int[] ans = {-1,-1};
//        int n=right-left + 1;
//        boolean[] prime = new boolean[n+1];
//        for (int i=0; i<=n; i++){
//            prime[i]=true;
//        }
//        int index1=0;
//        int count=0;
//        for (int i=left; i<=right; i++){
//            if ((i==1) || (i%2==0 && i!=2) || (i%3==0 && i!=3) || (i%5==0 && i!=5) || (i%7==0 && i!=7)){
//                prime[index1]=false;
//                count++;
//            }
//            index1++;
//        }
//        int[] mat = new int[n-count];
//        int index=0;
//        int index2=n-1;
//        for (int i=right; i>=left; i--){
//            if (prime[index2--]){
//                mat[index++]=i;
//            }
//        }
//
//if (index>1) {
//   int k=0;
//   ans[1] = mat[k++];
//   ans[0] = mat[k];
//
//   while (k<mat.length-1) {
//       if ((mat[k]-mat[k+1]) <= (mat[k-1] - mat[k])){
//            ans[1]=mat[k];
//            ans[0]=mat[k+1];
//       }
//       k++;
//   }
//}
//        return ans;
    }
}
