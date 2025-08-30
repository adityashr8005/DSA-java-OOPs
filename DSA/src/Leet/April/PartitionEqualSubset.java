package Leet.April;


public class PartitionEqualSubset {
    public static void main(String[] args) {
        int[] array = {1,5,11,5};
        System.out.println(canPartition(array));
    }
    static boolean canPartition(int[] nums){

        int sum=0;
        for (int num:nums){
            sum += num;
        }
        if (sum%2 != 0){
            return false;
        }

        int half=sum/2;
        return sum(nums, half);

    }
    static boolean sum(int[] num, int x){

        return false;
    }
}
