package DSA_Kunal.StringHandling;

public class Performance {
    public static void main(String[] args) {
        String series = "";
        for(int i=0;i<28;i++){
            //problem:
            //after every loop new object id being created (a,ab,abc,abcd...)
            //It is not changing original object as we know string are immutable.
            //So,it's creating new string object and copying the old one and appending the new changes.
            //a ,ab ,abc,..., abc..y will have no reference variable.
            //solution:
            //StringBuilder
            char ch = (char)('a'+i);
            series = series + ch;
        }
        System.out.println(series);
    }
}
