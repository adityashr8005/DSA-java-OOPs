

import java.util.Scanner;
public class Tempr {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in celcius : ");
        float temp = input.nextFloat();
        float result = (temp * 9/5 ) + 32;
        System.out.print("Temperature in Fahrenheit : " + result);


    }
}
