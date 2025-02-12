package Leet.OO1;

public class Atoi_String_Int {
    public static void main(String[] args) {
        String s = "-042";
        int ans = atoi(s);
        System.out.println(ans);
    }
    static int atoi(String s){
        int sum=0;
        int i=0;
        int sign=1;
        boolean check=false;
        if ((s.charAt(i)<48 || s.charAt(i)>57) && s.charAt(i)!=45){
            return 0;
        }

        if (s.charAt(i)==45){
            check = true;
            sign = sign* (-1);
            i++;
        }

            for ( ; i < s.length(); i++) {
                if (s.charAt(i) < 58 && s.charAt(i) > 47) {
                    sum = sum * 10 + s.charAt(i) - 48;
                } else {
                    break;
                }
            }
//            return check ? -sum:sum;
    return sum*sign;
    }

}
