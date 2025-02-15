package Leet.OO1;

import java.util.Hashtable;

public class DifferenceFrequency {
    public static void main(String[] args) {

        String s = "aaaabbc";
        int ans = maxDifference(s);
        System.out.println(ans);
    }
    static int maxDifference(String s){
        Hashtable<Character,Integer> map = new Hashtable<>();

        for (int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        int x=s.length(),y=0;
        for (int j=0; j<s.length(); j++){
            int a = map.get(s.charAt(j));
            if (a%2==0){
                if (a<=x){
                    x=a;
                }
            }else {
                if (a>=y){
                    y=a;
                }
            }
        }
        return y-x;
    }
}