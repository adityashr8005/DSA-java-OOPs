package DSA_Kunal.StringHandling;

public class StringBuilderClass {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<26;i++){
            char ch = (char)('a'+i);
            builder.append(ch); //It will not create new object just keep changing original object.
        }
        System.out.println(builder);  //abcdefghijklmnopqrstuvwxyz
        builder.deleteCharAt(0);
        System.out.println(builder);
        builder.reverse();
        System.out.println(builder);  //bcdefghijklmnopqrstuvwxyz
    }
}
