package Leet.OO2;

import java.util.Hashtable;

/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
-             -
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
 */
public class Roman_Int {
    public static void main(String[] args) {
        String s = "CMXCIV";
        int ans = romanToInt(s);
        System.out.println(ans);
    }
    static int romanToInt(String s){
        Hashtable<Character,Integer> h = new Hashtable<>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);

        int sum = 0;
        //XCIX //(h.get(s.charAt(i+1))
        for (int i=s.length()-1;i>=0;i--){
            if (i<s.length()-1 && h.get(s.charAt(i+1))>h.get(s.charAt(i)) ){
                sum -=  h.get(s.charAt(i));
            }else {
                sum += h.get(s.charAt(i));
            }
        }
        return sum;
    }
}
