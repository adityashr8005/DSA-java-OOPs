package DSA_Kunal.StringHandling;

//Strings are immutable in java means
//                               (if there are 10 reference variable equals to "String" ,
//                               it will not create 10 objects of "Strings" , it will have
//                               only one Strings to heap memory. And if one ref variable
//                               is changed it doesn't affect other variable it will remain
//                               same as "String".)
public class String0 {
    public static void main(String[] args) {
        //name1 and name2 are in heap inside same pool.
        String name1 = "Aaditya";
        String name2 = "Aaditya";
        System.out.println(name1==name2); //Checking if both ref variable pointing to same object or not.
        System.out.println();

        //Here, a and b are in heap but outside pool creating two object of "Aaditya".
        String a = new String("Aaditya");
        String b = new String("Aaditya");
        System.out.println(a==b); //Checking if both ref variable pointing to same object or not.
                                  //Give false cause a and b are not pointing to same object of heap.

        //When you need to check value use .equals method.
        System.out.println(a.equals(b)); //It doesn't check if ref variable is pointing to same object or not.
                                         //It just checks the value.
                                         //If there is space before or after string it return false.
        System.out.println(a.charAt(0)); //Gives first character of string.
    }
}
