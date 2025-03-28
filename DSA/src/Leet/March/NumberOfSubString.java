package Leet.March;

import java.util.Hashtable;

public class NumberOfSubString {
    public static void main(String[] args) {
        String str = "abcabc";
        int ans = numberOfSubstring(str);
        System.out.println(ans);
    }
    static int numberOfSubstring(String s){

        Hashtable<String,Boolean> h = new Hashtable<>();

        int count2=0;
        for (int i=0; i<=s.length()-3; i++){

            int end=s.length();
            while (3<=end) {
                h.put("a",false);
                h.put("b",false);
                h.put("c",false);
                for (int j = i; j < end; j++) {
                    if (s.charAt(j) == 'a' || s.charAt(j) == 'b' || s.charAt(j) == 'c') {
                        h.put(String.valueOf(s.charAt(j)), true);
                    }
                }
                if (!h.contains(false)) {
                    count2++;
                }
                end--;
            }
        }
        return count2;
    }
}
