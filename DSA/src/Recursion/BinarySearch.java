package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        //Initilizes array
        int[] arr = {1,3,5,7,9,10,20};
        int target = 1;
        int s=0;
        int e= arr.length-1;
        int ans = search(arr,target,s,e);
        System.out.println("The target element "+target+" is at index "+ans);
    }
    static int search(int[] arr, int target, int s, int e){
        int mid = (s+e) /2;
        //Base condition
        if(target == arr[mid]){
            return mid;
        }

        if (target>arr[mid]){
            return search(arr,target,mid+1,e);
        }
            return search(arr,target,s,mid-1);
    }
}
