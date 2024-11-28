package DSA_Kunal.Algorithm.CyclicSort;

//cyclic range is 0-N. [Given element is 0,1,2,3,5,6,7 then missing one is 4].
//                     [Given element is 0,1,2,3,4,5,6 then missing one is 7].
public class MissingNumber {
    public static void main(String[] args) {
        int [] arr = {0,1,2,3,4,5,8,7};
       int ans = search(arr);
        System.out.println(ans + " is a missing number.");
    }
    static int search(int[] arr){
            for (int i=0;i<arr.length;i++) {
                // int correct=arr[i]-1; //use this in case first index is 1 (arr[0]=1).
                if (arr[i] != i) {
                  return i;
                }
        }
        return arr.length;
    }
}
