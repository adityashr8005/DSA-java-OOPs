import java.util.Arrays;

public class MaxOfArray {
    public static void main(String[] args) {
        int[] arr = {2 , 4 , 34 , 43 , 21};
        System.out.println(Arrays.toString(arr));
        System.out.print("Maximun value in an array is : " + max(arr));
    }

    static int max(int[] arr){
        int maxVal= arr[0];
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i]>maxVal){
                maxVal = arr[i];
            }
        }
        return maxVal;
    }
}

