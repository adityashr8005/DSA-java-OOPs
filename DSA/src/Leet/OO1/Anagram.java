package Leet.OO1;

public class Anagram {
    public static void main(String[] args) {
        String s="aacc";
        String t="ccac";

        System.out.println(isAnagram(s,t));
    }
    static boolean isAnagram(String s, String t){
        if(s.length() != t.length())
            return false;

        int[] f = new int[26];
        for(int i = 0; i < s.length(); i++) {
            f[s.charAt(i) - 'a']++;
            f[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < f.length; i++)
            if(f[i] > 0)
                return false;

        return true;
    }
}
