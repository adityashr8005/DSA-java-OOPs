import java.util.Arrays;

public class Armstrong1 {
    public static void main(String[] args) {
        int num = 153;
        int digit = 0;

        // Find total digits in num
        digit = (int)Math.log10(num) + 1;
        int sum = 0;
        while(num>0) {
         int rem = num % 10;
            int cube = (int)Math.pow(rem, 3);
            sum +=cube;
            num /=10;
        }
        if(sum == num) {
            System.out.println("Armstrong");
        }else{
            System.out.println("NOt Armstrong");
        }
    }

    public static class Reverse {
        public static void main(String[] args) {
            int[] arr = {1,2,3,4,5,6,7,8,9};
            System.out.println(Arrays.toString(arr));
            System.out.println("After Reversing Array.");
            reverse(arr);
            System.out.println(Arrays.toString(arr));
        }
        static void reverse(int[] arr){
            int i = 0;
            int j = arr.length-1;
            while(i<j){
                int temp=arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }
}
