package DSA_Kunal.Binary;

//ceiling search means searching of elements greater than or equal to target element.
public class CeilingSearch {
    public static void main(String[] args) {
        int[] arr = {-9, -3, 0, 1, 4, 6, 10, 12, 34, 44, 56, 78, 99};
        int target = 99;
        int ans=ceiling(arr,target);
        System.out.println("Target found at index " + ans + "\nTarget number is " + arr[ans]);
    }

    static int ceiling(int[] arr, int target){
        if(target>arr[arr.length-1]){
            return -1;
        }
        int s=0;
        int e= arr.length-1;
        int mid=0;
        while(s <= e) {
            mid = s + (e-s) /2;//Similar as (s+e)/2

            if (target > arr[mid]) {
                s = mid + 1;
            }
            else if (target < arr[mid]){
                e=mid-1;
            }
            else
                return mid;
        }
        //ceiling = return smallest element greater than or equal to target element.
        return s;  //return the smallest greater value from an array of target element.
   }
}
