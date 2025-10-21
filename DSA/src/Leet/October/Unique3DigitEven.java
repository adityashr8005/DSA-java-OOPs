package Leet.October;

import java.util.HashSet;

/*
Example 1:
Input: digits = [1,2,3,4]
Output: 12

Explanation: The 12 distinct 3-digit even numbers that can be formed are
124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432.
Note that 222 cannot be formed because there is only 1 copy of the digit 2.
 */
public class Unique3DigitEven {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(totalDigits(arr));
    }

    public static int totalDigits(int[] digits){
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<digits.length; i++){
            if (digits[i]==0){
                continue;
            }

            for (int j=0; j<digits.length; j++){
                if (i==j) continue;

                for (int k=0; k<digits.length; k++){
                    if (i==k || j==k) continue;

                    if (digits[k]%2 == 0){
                        set.add(digits[k]*100 + digits[j]*10 + digits[i]);
                    }
                }
            }
        }
        return set.size();
    }
}
