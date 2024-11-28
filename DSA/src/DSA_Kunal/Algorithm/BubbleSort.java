// Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are
// in the wrong order. This algorithm is not suitable for large data sets as its average and worst-case time complexity
// are quite high.

package DSA_Kunal.Algorithm;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {3,4,5,2,1};
        System.out.println("Before BubbleSorting:" + Arrays.toString(arr));
        bubble(arr);
        System.out.println("After BubbleSorting:" + Arrays.toString(arr));
    }
    static void bubble(int[] arr){
        boolean check;
        //Run the steps n-1 times.
        for(int i=0 ; i<arr.length ; i++){
            check = false;
            //for each step, max item will come at last index.
            for(int j=1 ; j< arr.length-i; j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    check=true;
                }
            }
            if(!check){
                break;
            }
        }
    }
}
