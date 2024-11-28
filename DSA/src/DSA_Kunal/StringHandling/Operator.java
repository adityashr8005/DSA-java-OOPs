package DSA_Kunal.StringHandling;

import java.util.ArrayList;

public class Operator {
    public static void main(String[] args) {
        System.out.println('a'+'b'); //195 //convert to ASCII/unicode and add using + operator.
        System.out.println('d');     //d
        System.out.println("a"+"b"); //ab  //concatenate a and b using + operator
        System.out.println('a'+3);   //100 //convert a into it's integer value and add 3.
        System.out.println((char)('a'+3));   //d
        // convert unicode to in corresponding alphabet[(a=97)+3]==100==d.

        System.out.println("a"+1);
        //This is same as after a few step:"a"+"1".
        //a1 -> integer will convert to Integer that will call toString().

        //convert everything to string then + operation perform.
        System.out.println("Aditya"+new ArrayList<>()); //Aditya[] -> cause arrayList is empty.

        //NOTE:Operator '+' in java is only defined for primitive and if any one of them is of String
        //System.out.println(new Integer(56) + new ArrayList<>());
        //It will show error cause there is no any string only expression ,
        // So, at least one has to be string.
        System.out.println(new Integer(55) + " " + new ArrayList<>());//55 [] --> Output is of string type.
    }
}
