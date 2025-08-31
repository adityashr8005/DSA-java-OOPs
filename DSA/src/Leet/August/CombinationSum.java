package Leet.August;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums={3};
        int target=4;
        int ans = combination(nums,target);
        System.out.println(ans);
    }
    static int combination(int[] nums, int target){
        int[] temp = new int[target+1];
        temp[0]=1;
        for (int i = 0; i <= target; i++) {
            for (int num:nums){
                if (num<=i){
                    temp[i] += temp[i-num];
                }
            }
        }
        return temp[target];
    }
}
