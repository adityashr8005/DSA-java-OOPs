package Leet.October;

public class DateToBinary {
    public static void main(String[] args) {
        String date = "2080-02-29";
        System.out.println(dateToBin(date));
    }

    public static String dateToBin(String date){
        String[] digits = date.split("-");
        StringBuilder s = new StringBuilder();

        for (int i=0; i<digits.length; i++){
            int num = Integer.parseInt(digits[i]);
            s.append(convert(num));

            if (i< digits.length-1){
                s.append("-");
            }
        }
        return s.toString();
    }

    static long convert(int num){
        long result = 0;
        int pow = 0;

        while (num>0){
            result = (long) (num%2 * Math.pow(10,pow++)) + result;
            num /= 2;
        }
        return result;
    }
}
