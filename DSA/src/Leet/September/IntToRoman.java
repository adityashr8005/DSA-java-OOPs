package Leet.September;

public class IntToRoman {
    public static void main(String[] args) {
        int num = 3749;
        System.out.println(intToRoman(num));
    }
    static String intToRoman(int num){
        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] symbol = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder s = new StringBuilder();

        for (int i=0; i<values.length && num>0; i++){
            while (num>=values[i]){
                s.append(symbol[i]);
                num -= values[i];
            }
        }
        return s.toString();
    }
}
