package DSA_Kunal.Binary;

public class FindInInfinityArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int target = 14;
        int ans = infinitySearch(arr,target);
        System.out.println("Target found at index " + ans + "\nTarget number is " + arr[ans]);
    }
    static int infinitySearch(int[] arr, int target){
        int s=0;
        int e=1;
        int mid=0;
        while(target!=arr[mid]) {

            while (s <= e) {
                mid = s + (e - s) / 2;

                if (target > arr[mid]) {
                    s = mid + 1;
                } else if (target < arr[mid]) {
                    e = mid - 1;
                } else{
                    return mid;
                }
            }
            //below code will double the searching list. Before 2 , after 4 , laterOn 8 and goesOn.
            s=e+1;
            e=(s*2)+1;
        }
      return mid;
    }
}
