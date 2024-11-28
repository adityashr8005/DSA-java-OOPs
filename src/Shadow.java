

public class Shadow {
    static int x = 45;
    public static void main(String[] args) {
        System.out.println(x); //45
        int x;
       // System.out.println(x); //Scope will begin after initialization.
        x = 90;
        System.out.println(x); //90
        fun();
    }

     static void fun() {
         System.out.println(x); //90
    }

}
