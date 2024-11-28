package Aditya;
import java.util.Scanner;
public class Case {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter : ");
        int ch = input.next().trim().charAt(0);

        if(ch >= 'a' && ch<='z'){
            System.out.println("It's LowerCase.");
        }
        else{
            System.out.println("It's UpperCase");
        }
    }
}
