public class EvensInArray {
    public static void main(String[] args) {
        int[] arr = {2 , 3 , 54 , 33 , 32};
        System.out.println(check(arr));
    }
    static int check(int[] arr){
        int count = 0;
        for(int element:arr){
            if(element%2 == 0){
                count++;
            }
        }
        return count;
    }
}
