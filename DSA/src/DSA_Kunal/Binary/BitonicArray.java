package DSA_Kunal.Binary;

public class BitonicArray {
    public static void main(String[] args) {
        //BitonicArray - MountainArray
        //input={1,3,5,7,6,4,2} << ans = 7 << peak value.
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int max=0;
        int ans = search(arr,max);
        System.out.println("Peak value of an array is " + arr[ans] + " at index " + ans);
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
}
