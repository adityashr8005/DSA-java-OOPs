public class SearchElementOfArray {
    public static void main(String[] args) {
        int[] arr = {2 , 56 , 23 , 12 , 22};
        int target = 222;
        System.out.println(search(arr , target));
    }
    static int search(int[] arr , int target){
        for(int i=0 ; i<arr.length ; i++){

            if(target==arr[i]){
                return i;
            }
        }
        System.out.print("Elements not found.");
        return 0;
    }
}
