package DSA_Kunal.StringHandling;

import java.util.Arrays;

public class Output {
    public static void main(String[] args) {
        //First it goes with (String.valueOf(x)) then control goes to toString and return string.
        System.out.println(56);
        System.out.println("String");

        //Here, toString get override and give own output not a default one as done above.
        System.out.println(Arrays.toString(new int[]{2,4,6,8}));
        //Output : [I@7b23ec81  //run default toString and return random value.
        System.out.println(new int[]{2,4,6,8});

        //Check obj==null and return null.
        String num=null;
        System.out.println(num);
    }
}
