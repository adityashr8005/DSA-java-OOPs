//Selection Sort is a comparison-based sorting algorithm. It sorts an array by repeatedly selecting the smallest (or largest)
// element from the unsorted portion and swapping it with the first unsorted element. This process continues until the entire
// array is sorted.

package DSA_Kunal.Algorithm;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
       int[] arr={2,4,1,5,3};
        System.out.println("Before SelectionSorting:" + Arrays.toString(arr));
        alter(arr,0,arr.length-1);
        System.out.println("\nAfter SelectionSorting:" + Arrays.toString(arr));
    }

    static void alter(int[] arr,int start,int end) {
        while (start < end) {
            int max = 0;
            for (start=0; start < end; start++) {
                if (arr[max] <= arr[start]) {
                    max = start;
                }
            }
            swap(arr, max,end);
            end--;
            alter(arr, 0 , end);
        }
    }
    static void swap(int[] arr,int max,int last){
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last]=temp;
    }
}
