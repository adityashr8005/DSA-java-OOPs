package Leet.OO1;

public class test1 {
    public static void main(String[] args) {
        int[] nums={2,4,5,3};
        int target=8;
        twoSum(nums,target);

    }

    static int[] twoSum(int[] nums,int target){

        for (int i=0; i< nums.length; i++){
            int j=i+1;
            if (nums[i]+nums[j]==target){
                return new int[] {i,j};
            }
        }
        return null;
    }
}
