import java.util.Scanner;
public class Add{
    public static void main(String[] args) {
        //Finding perimeter and area 
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Length:");
        int l = input.nextInt();
        System.out.print("Enter Breadth:");
        int b = input.nextInt();
        int perimeter = 2*(l+b);
        int area = l*b;
        System.out.println("Perimeter is " + perimeter);
        System.out.println("Area is " + area);
    }
}
