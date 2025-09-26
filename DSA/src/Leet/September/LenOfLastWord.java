package Leet.September;

public class LenOfLastWord {
    public static void main(String[] args) {
        String s = "hello world  ";
        System.out.println(countLastWord(s));
    }

    static int countLastWord(String s){
        int n = s.length()-1;
        int count = 0;
        char ch = s.charAt(n);
        while (ch == 32){
            n--;
            ch = s.charAt(n);
        }

        for (int i = n; i>=0; i--){
            ch = s.charAt(i);
            if (ch == 32){
                break;
            }
            count++;
        }
        return count;
    }
}
