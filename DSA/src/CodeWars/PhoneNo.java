package CodeWars;

/*
Example
Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
 */
public class PhoneNo {

    public static String createPhoneNumber(int[] numbers){
        StringBuilder str = new StringBuilder();

        str.append("(");
        for (int i = 0; i<numbers.length; i++){
            if (i == 3){
                str.append(") ");
            }
            if (i==6){
                str.append("-");
            }
            str.append(numbers[i]);
        }

        return str.toString();

//        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
//                numbers[0], numbers[1], numbers[2],
//                numbers[3], numbers[4], numbers[5],
//                numbers[6], numbers[7], numbers[8], numbers[9]
//                );
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,0};

        System.out.println(createPhoneNumber(numbers));
    }
}
