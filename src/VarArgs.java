import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
         fun(2,3,4,5,6,7,8);
    }

  static void fun( int ...v) {
      System.out.println(Arrays.toString(v));
    }
}


















//import java.util.Arrays;
//public class VarArgs{
//    public static void main(String[] args) {
//        fun(3308 , 2253 , "Aditya" , "Arnav" , "Bikki");
//    }
//    static void fun(int a ,int b ,String ...v){
//
//        System.out.println(Arrays.toString(v));
//    }
//}