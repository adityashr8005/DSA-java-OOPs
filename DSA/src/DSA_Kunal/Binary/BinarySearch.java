//Binary search follows the divide and conquer approach in which the list is divided into two halves, and the item is compared
// with the middle element of the list. If the match is found then, the location of the middle element is returned. Otherwise,
// we search into either of the halves depending upon the result produced through the match.

package DSA_Kunal.Binary;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-9, -3, 0, 1, 4, 6, 10, 12, 34, 44, 56, 78, 99};
        int target = 56;
        int ans=ceiling(arr,target);
        System.out.println("Target found at index " + ans + "\nTarget number is " + arr[ans]);
    }
    static int ceiling(int[] arr, int target){
        int s=0;
        int e= arr.length-1;
        int mid = s + (e-s) /2;  //Similar as (s+e)/2

        if(target==arr[mid]){
            return mid;
        }
        while(target!=arr[mid]) {
            if (target > arr[mid]) {
                s = mid + 1;
                mid = (s + e) / 2;
                if (target == arr[mid]) {
                    return mid;
                }
            }
            else{
                e=mid-1;
                mid = (s+e) /2;
                if(target==arr[mid]){
                    return mid;
                }
            }
        }
        return 0;
    }
}
