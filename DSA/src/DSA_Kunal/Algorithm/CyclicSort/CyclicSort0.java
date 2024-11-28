package DSA_Kunal.Algorithm.CyclicSort;

import java.util.Arrays;

//NOTE : if array of element is given 1 - N simply use cyclicSort...
public class CyclicSort0 {
    public static void main(String[] args) {
       int [] arr = {4,3,2,5,1};
        System.out.println("Before CyclicSorting:" + Arrays.toString(arr));
       sort(arr);
       System.out.println("After CyclicSorting:" + Arrays.toString(arr));
    }
    static void sort(int[] arr){
        int i=0;
        while(i< arr.length){
        int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
               swap(arr,i,correct);
            }else
                i++;
        }

    }
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;

    }
}
