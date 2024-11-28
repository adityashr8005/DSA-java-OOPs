// Insertion sort is a simple sorting algorithm that works by iteratively inserting each element of an unsorted list into its
// correct position in a sorted portion of the list. It is like sorting playing cards in your hands. You split the cards into
// two groups: the sorted cards and the unsorted cards. Then, you pick a card from the unsorted group and put it in the right
// place in the sorted group.
//
//We start with second element of the array as first element in the array is assumed to be sorted.
//Compare second element with the first element and check if the second element is smaller then swap them.
//Move to the third element and compare it with the first two elements and put at its correct position
//Repeat until the entire array is sorted.


package DSA_Kunal.Algorithm;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
      int[] arr = {3,2,4,1,5};
        System.out.println("Before InsertionSorting:" + Arrays.toString(arr));
      sort(arr);
      System.out.println("After InsertionSorting:" + Arrays.toString(arr));
    }
    static void sort(int[] arr){
        for(int i=0;i<arr.length-2;i++){
            for (int j=i+1;j>0;j--){
                if(i>j){
                    break;
                }
                if (arr[j]<arr[i]){
                    swap(arr,i,j);
                    if (i>0){
                        i--;
                    }
                }
            }
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
