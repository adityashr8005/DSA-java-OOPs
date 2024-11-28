package DSA_Kunal.Binary;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr= {1,2,4,7,7,7,9,22};
        int target = 7;
        int start=search(arr,target,true);
        int end=search(arr,target,false);
        System.out.println("First occurence of target element is at " + start + "\nLast occurence of target element is at " + end);
    }
    static int search(int[] arr, int target,boolean startIndex){
        int result=0;
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
                result = mid;
                    if(startIndex) {
                        e = mid - 1;
                    }else
                        s = mid + 1;
                }
        }
        return result;
    }
}
