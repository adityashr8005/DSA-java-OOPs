package Leet.October;

/*
Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "111";
        String b = "11";
        System.out.println("a=" + a + " b=" + b);
        System.out.println("Normal Addition:"+addNumber(a,b));
        System.out.println("Binary Addition:"+addBinary(a,b));
    }

    public static String addNumber(String a, String b){
        StringBuilder s1 = new StringBuilder();

        int n = a.length();
        int m = b.length();
        int carry = 0;
        int i=n-1;
        int j=m-1;

        while (i>=0 && j>=0){
                int num1 = a.charAt(i) - '0';
                int num2 = b.charAt(j) - '0';

                int sum = num1 + num2 + carry;

                int rem = sum%10;
                carry = sum/10;

                s1.append(rem);

                i--;
                j--;
        }

        if (i == -1 && j == -1){
            s1.append(carry);
        }
        while (i>=0){
            s1.append(a.charAt(i));
            i--;
        }
        while (j>=0){
            s1.append(b.charAt(j));
            j--;
        }

       return s1.reverse().toString();
    }
//
    public static String addBinary(String a, String b){
        StringBuilder s1 = new StringBuilder();

        int n = a.length();
        int m = b.length();
        int carry = 0;
        int i;
        int j=m-1;

        if (n<m){
            return addBinary(b,a);
        }
        for (i=n-1; i>=0; i--){
            int num1 = a.charAt(i) - '0';

            int sum = num1 + carry;

            if (j>=0){
                int num2 = b.charAt(j) - '0';
                sum += num2;
                j--;
            }
            int rem = sum%2;
            carry = sum/2;

            s1.append(rem);
        }

        if (carry>0){
            s1.append(1);
        }
        return s1.reverse().toString();
    }
}
