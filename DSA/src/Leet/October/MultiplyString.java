package Leet.October;

/*
Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class MultiplyString {
    public static void main(String[] args) {
        String num1 = "22";
        String num2 = "33";
        System.out.println(multiplyString(num1,num2));
    }
    public static String multiplyString(String num1, String num2){
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m+n];

        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder str = new StringBuilder();
        for (int p : pos){
            if (!(str.isEmpty() && p==0)){
                str.append(p);
            }
        }
        return str.toString();

        //1st Approach not optimised for longer string...
//        int a=0, b=0;
//        for (int i=0; i<num1.length(); i++){
//            a = a*10 + num1.charAt(i)-48;
//        }
//
//        for (int i=0 ; i<num2.length(); i++){
//            b = b*10 + num2.charAt(i)-48;
//        }
//
//        int c = a*b;
//        StringBuilder str = new StringBuilder();
//        str.append(c);
//        return str.toString();

        //2nd Approach
//        int m = num1.length(), n = num2.length();
//        int[] pos = new int[m + n];
//
//        for (int i = m - 1; i >= 0; i--) {
//            for (int j = n - 1; j >= 0; j--) {
//                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//                int p1 = i + j, p2 = i + j + 1;
//                int sum = mul + pos[p2];
//
//                pos[p1] += sum / 10;
//                pos[p2] = (sum) % 10;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int p : pos)
//            if (!(sb.length() == 0 && p == 0))
//                sb.append(p);
//        return sb.length() == 0 ? "0" : sb.toString();
    }
}
