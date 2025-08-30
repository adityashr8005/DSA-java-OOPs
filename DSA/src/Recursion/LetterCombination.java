package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
       combination("", "12");
        System.out.println(combinations("","12"));
    }
    static void combination(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';

        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch=(char) ('a'+i);
            combination(p+ch,up.substring(1));
        }
    }

    static List<String> combinations(String p, String up){
        if (up.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        List<String> list = new ArrayList<>();
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch=(char) ('a'+i);
            list.addAll(combinations(p+ch, up.substring(1)));
        }
        return list;
    }
}
