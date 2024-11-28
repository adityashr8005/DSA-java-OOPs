package DSA_Kunal.Algorithm.CyclicSort;

public class MissingNO {

    public static void main(String[] args) {
        int [] arr = {5,0,2,1,4};
       int ans = sort(arr);
        System.out.println(ans + " is a missing number.");
    }
    static int sort(int[] arr){

        //First sort the array.
        int i=0;
        while(i< arr.length){
            int correct=arr[i];
            if(arr[i]<arr.length && arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else
                i++;
        }

        //Here comes , finding the missing one...
        for (int j=0;j<arr.length;j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        //if no missing return next upcoming number in element of array.
        return arr.length;
    }

    //this swap the element to its correct index.
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]=temp;
    }
}
