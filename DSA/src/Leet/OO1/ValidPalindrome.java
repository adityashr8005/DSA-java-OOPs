package Leet.OO1;

//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.

//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        //Making string in lowerCase.
        String str = s.toLowerCase();

        //Creating two string for comparing. One for removing unwanted character and other to store reversed character.
        String str0 = "";
        String str1 = "";

        //Loop for arranging only alphabets.
        for (int i=0; i<str.length() ; i++){
            if (str.charAt(i)<=122 && str.charAt(i)>=97){
                str0 = str0 + str.charAt(i);
            } else if (str.charAt(i)<=57 && str.charAt(i)>=48) {
                str0 = str0 + str.charAt(i);
            }
//            else if (str.charAt(i)==95) {
//                str0 = str0 + str.charAt(i);
//            }
        }
        System.out.println(str0);

        //Loop for reversing string.
        for (int i=str.length()-1 ; i>=0 ; i--){
            if (str.charAt(i)<=122 && str.charAt(i)>=97){
                str1 = str1 + str.charAt(i);
            } else if (str.charAt(i)<=57 && str.charAt(i)>=48) {
                str1 = str1 + str.charAt(i);
            }
//            else if (str.charAt(i)==95) {
//                str1 = str1 + str.charAt(i);
//            }
        }
        System.out.println(str1);

        //Return true id string are equals.
        if (str0.equals(str1)){
            return true;
        }
        return false;
    }
}
