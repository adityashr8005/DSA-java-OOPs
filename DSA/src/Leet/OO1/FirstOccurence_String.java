package Leet.OO1;

public class FirstOccurence_String {
    public static void main(String[] args) {

        String haystack = "mississippi";
        String needle = "issip";
        int ans = strStr(haystack, needle);
        System.out.println(ans);
    }
    static int strStr(String haystack, String needle){
        int i;
        for (i=0; i<haystack.length(); i++) {
            int count=0, j=0;
            int k = i;
            while ( k<haystack.length() && j<needle.length() && (haystack.charAt(k) == needle.charAt(j))) {
                j++;
                k++;
                count++;
            }
            if (count==needle.length()){
                return k-needle.length();
            }
        }

        return -1;


//        Shortcut method with 0ms.
//        return haystack.indexOf(needle);
    }
}
