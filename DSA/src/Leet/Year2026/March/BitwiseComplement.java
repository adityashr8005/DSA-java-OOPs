package Leet.Year2026.March;

public class BitwiseComplement {

    public static int bitwiseComplement(int n){

        String s = Integer.toBinaryString(n);
        int length = s.length();

        int value =(int) Math.pow(2,length) - 1;
        return n^value;
    }
    public static void main(String[] args) {
        int n = 5;
        int ans = bitwiseComplement(n);
        System.out.println(ans);
    }
}
