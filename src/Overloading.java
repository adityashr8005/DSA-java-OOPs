public class Overloading {
    public static void main(String[] args) {
       int ans = fun(2,3);
        System.out.println(ans);
      String result = fun("Kavi" , "Rahul");

    }
    static int fun(int a , int b){

        return a + b;
    }
    static String fun(String a , String b){
        System.out.println(a + " " + b );
        return a + b;
    }

}
