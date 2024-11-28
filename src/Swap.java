





public class Swap {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println("a = "+ a + " b = " + b + "\n");
        swap(a,b);
    }
    static void swap(int a , int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After Swapping");
        System.out.println("a = " + a + " b = " + b );
    }
}


//public class Swap {
//    public static void main(String[] args) {
//        swap(2,3);
//    }
//    static void swap(int num1 , int num2){
//        int temp = num1;
//        num1 = num2;
//        num2 = temp;
//        System.out.println(num1 + " " + num2 );
//    }
//}
