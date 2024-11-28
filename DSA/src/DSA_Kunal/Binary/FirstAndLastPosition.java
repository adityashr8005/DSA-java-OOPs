package DSA_Kunal.Binary;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,7,7,8,8,9};
        int target = 7;
        int[] ans = searchRange(arr,target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] searchRange(int[] arr, int target){
        int[] ans = {-1,-1};
        int start = search(arr, target, true);
        int end = search(arr,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
    static int search(int[] arr,int target, boolean findStartIndex){
        int ans = -1;
        int s=0;
        int e= arr.length-1;
        int mid;
        if(target > arr[arr.length-1]){
            return -1;
        }
        while(s <= e) {
            mid = s + (e-s) /2;

            if (target > arr[mid]) {
                s = mid + 1;
            }
            else if (target < arr[mid]){
                e=mid-1;
            }
            else{
             ans = mid;
             if(findStartIndex){
                 e=mid-1;
             }else{
                 s=mid+1;
             }
          }
       }
        return ans;
    }
}
