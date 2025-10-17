package TempQuestions;

public class ConversionNumSys {
    public static void main(String[] args) {
        System.out.println("Decimal of 1010 is " + binToDec(1010));
        System.out.println("Binary of 10 is " + decToBin(10));

        System.out.println("Binary to Decimal : " + decToBinary("2080-02-29"));
    }

    public static int binToDec(int num){
        int result=0;
        int pow=0;
        int last;

        while (num > 0){
            last = num%10;
            result = (int)(last * Math.pow(2,pow++)) + result;
            num /= 10;
        }
        return result;
    }

    public static int decToBin(int num){
        int result = 0;
        int pow = 0;

        while (num>0){
            result = (int) (num%2 * Math.pow(10,pow++)) + result;
            num /= 2;
        }
        return result;
    }

    public static String decToBinary(String num){
        //"2080-02-29"
        String[] digits = num.split("-");
        StringBuilder s = new StringBuilder();

        for (int i=0; i<digits.length; i++){
            int date = Integer.parseInt(digits[i]);
            s.append(convert(date));
            if (i<digits.length-1){
                s.append("-");
            }
        }
        return s.toString();
    }
    public static long convert(int num){
        long result = 0;
        int pow = 0;

        while (num>0){
            result = (long) (num%2 * Math.pow(10,pow++)) + result;
            num /= 2;
        }
        return result;
    }
}
