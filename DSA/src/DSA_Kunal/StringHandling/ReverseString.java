package DSA_Kunal.StringHandling;

import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter:");
        String str = sc.next();
        builder.append(str);
        builder.reverse();
        System.out.println("After reverse:"+builder);
    }
}
