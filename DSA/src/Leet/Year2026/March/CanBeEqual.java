package Leet.Year2026.March;

public class CanBeEqual {

    public static boolean canBeEqual(String s1, String s2){
//        if (s1.chars().sum() != s2.chars().sum()) return false;
//
//        int i;
//        for (i=0; i<2; i++){
//            if (s1.charAt(i) != s2.charAt(i)){
//                if (s1.charAt(i) != s2.charAt(i+2)){
//                    return false;
//                }
//            }
//        }
//        return s1.charAt(i) != s2.charAt(i + 1) && s1.charAt(i) != s2.charAt(i - 1);

        return ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0))) &&
                ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                        (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)));

    }
    public static void main(String[] args) {
        String s1 = "ffww";
        String s2 = "wwff";

        System.out.println(canBeEqual(s1,s2));
    }
}
