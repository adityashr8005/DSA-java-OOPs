package DSA_Kunal.Binary;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,9,8,7,3,1};
        int target=3;
        int ans = binarySearch(arr,target);
        System.out.println("Target element is at " + ans + " index.");
    }
    static int search(int[] arr, int max){
        int s=0;
        int e=arr.length-1;
        int mid;
        while(arr[max]<arr[max+1]) {
            mid=s+(e-s) / 2;
            if(arr[mid]<arr[mid+1]){
                max=mid+1;
            }else
                max=mid;
        }
        return max;
    }

    static int binarySearch(int[] arr,int target){
      int s=0;
      int e=arr.length-1;
      int mid=0;
      while(s<=e){
          mid=s+(e-s)/2;
          if(target<arr[mid]){
              e=mid-1;
          } else if (target>arr[mid]) {
              s=mid+1;
          }else
              return mid;
      }
        return mid;
    }
}
