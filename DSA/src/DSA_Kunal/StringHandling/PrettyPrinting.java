package DSA_Kunal.StringHandling;

public class PrettyPrinting {
    public static void main(String[] args) {
        float a = 43.12654f;
        float b = 43.12224f;
        //It will format the number to .xx decimal also rounding it up.
        System.out.printf("Formated number is %.2f",a); // 43.13
        System.out.println();
        System.out.printf("Formated number is %.3f",b); // 43.122
        System.out.println();
        System.out.printf("PI : %.3f",Math.PI); //PI : 3.142
        System.out.println();
        System.out.printf("PI : %.5f",Math.PI); //PI : 3.14159
        System.out.println();
        System.out.printf("Hello my name is %s and I am %d years old." , "Aaditya" , 20); //Like C programming.
    }
}
