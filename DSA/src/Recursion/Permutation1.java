package Recursion;

import java.util.ArrayList;

public class Permutation1 {
    public static void main(String[] args) {
        subSeq("", "abc");
        System.out.println(permutation("", "abc"));
    }
    static void subSeq(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i=0; i<=p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i);
            subSeq(first+ch+second,up.substring(1));
        }
    }

    static ArrayList<String> permutation(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        //Local ans
        ArrayList<String> ans = new ArrayList<>();
        for (int i=0; i<=p.length(); i++){
            String first = p.substring(0,i);
            String second = p.substring(i);
            ans.addAll(permutation(first+ch+second, up.substring(1)));
        }
        return ans;
    }
}
