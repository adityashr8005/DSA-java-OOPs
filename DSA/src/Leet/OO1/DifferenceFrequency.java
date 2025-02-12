package Leet.OO1;

public class DifferenceFrequency {
    public static void main(String[] args) {

        String s = "abcabca";
        int ans = maxDifference(s);
        System.out.println(ans);
    }
    static int maxDifference(String s){
        int count1=0;
        int count2=0;
        int count3=0;
//        int i, j;
        for (int i=0; i<1; i++){
            for (int j=0; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count1++;
                }
            }
        }
        for (int i=count1; i<count1+1; i++){
           for (int j=0; j<s.length(); j++){
               if (s.charAt(i)==s.charAt(j)){
                   count2++;
               }
           }
        }

        if ((count1%2==0 && count2%2==0) || (count1%2!=0 && count2%2!=0)){
            int k=count1+count2;
            for (int i=k; i<k+1; i++){
                for (int j=0; j<s.length(); j++){
                    if (s.charAt(i)==s.charAt(j)){
                        count3++;
                    }
                }
            }
            if (count1>count2) {
                if ((count1 % 2 == 0 || count3 % 2 == 0) && (count1 % 2 != 0 || count3 % 2 != 0)) {
                    if (count1 > count3) {
                        return count1 - count3;
                    }
                    return count3 - count1;
                }
            }
            if ((count2 % 2 == 0 || count3 % 2 == 0) && (count2 % 2 != 0 || count3 % 2 != 0)) {
                if (count2 > count3) {
                    return count2 - count3;
                }
                return count3 - count2;
            }
        }

        if ((count1%2==0 || count2%2==0) && (count1%2!=0 || count2%2!=0)){
            if (count1>count2){
                return count1-count2;
            }
            return count2-count1;
        }
        return 0;
    }
}
