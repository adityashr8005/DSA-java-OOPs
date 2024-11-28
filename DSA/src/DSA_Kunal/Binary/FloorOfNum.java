package DSA_Kunal.Binary;

public class FloorOfNum {
    public static void main(String[] args) {
        int[] arr = {-9, -3, 0, 1, 4, 6, 10, 12, 34, 44, 56, 78, 99};
        int target = 3;
        int ans=ceiling(arr,target);
        System.out.println("Closest target found at index " + ans + "\nTarget number is " + arr[ans]);
    }

    static int ceiling(int[] arr, int target){
        int s=0;
        int e= arr.length-1;
        int mid=0;
        if(target > arr[arr.length-1]){
            return -1;
        }
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
        //floor = return greatest element less than or equal to target element.
        return e;  //return the greatest smaller value from an array of target element.

    }
}
