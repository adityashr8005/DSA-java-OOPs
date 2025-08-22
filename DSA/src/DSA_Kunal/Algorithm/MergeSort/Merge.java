package DSA_Kunal.Algorithm.MergeSort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

//Merge Sort using recursion.
    static int[] mergeSort(int[] arr){
        if (arr.length==1){
            return arr;
        }

        int mid = arr.length/2;

        //Copying a leftmost and rightmost array to a respective new array...
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        //Calling merge function to merge the arrays and sorting.
        return merge(left,right);
    }

    //merge function: that merge element via sorting and return.
    public static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i=0;
        int j=0;
        int k=0;

        while (i< first.length && j< second.length){
            if (first[i]<second[j]){
                mix[k]=first[i];
                i++;
                k++;
            }else {
                mix[k]=second[j];
                j++;
                k++;
            }
        }

        // Incase one of the (left,right) elements been sorted completely.
        while (i< first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while (j < second.length){
            mix[k]=second[j];
            j++;
            k++;
        }

        //return a sorted array...
        return mix;
    }
}
