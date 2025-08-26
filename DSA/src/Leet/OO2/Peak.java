package Leet.OO2;

public class Peak {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
//        int[] arr = {1,2,3,4,5,6,7,8,9,1};
        int ans = peakIndex(arr);
        System.out.println(ans);
    }
    static int peakIndex(int[] nums){
//        More time consuming
//        int max = 0;
//        int s = 0;
//        int e = nums.length-1;
//        int ans1=0;
//       int ans = peak(nums,max,s,e);
//        if (nums[ans]<nums[ans-1]){
//            ans1 = peak(nums, ans - 1, s, ans);
//            while(nums[ans1]<nums[ans1-1]) {
//                ans1 = peak(nums, ans1 - 1, s, ans1);
//            }
//            return ans1;
//        }
//     return ans;
//    }
//    static int peak(int[] nums, int max, int s, int e){
//        while (nums[max]<nums[max+1]){
//            int mid = s + (e-s) /2;
//            if (nums[mid]<nums[mid+1]){
//                max=mid+1;
//                s=mid;
//            }else if (nums[mid]<nums[mid-1]){
//                max=mid-1;
//                e=mid;
//            }else{
//                max=mid;
//            }
//        }
//        return max;


        //Less time-consuming
//        int start = 1;
//        int end = nums.length-2;
//
//        while(start <= end) {
//            int mid = (start + end)/2;
//            boolean left = nums[mid] > nums[mid-1];
//            boolean right = nums[mid] > nums[mid+1];
//
//            if(left && right) {
//                return mid;
//            }
//
//            else if (nums[mid-1] > nums[mid]) {
//                end = mid-1;
//            }
//
//            else {
//                start = mid+1;
//            }
//        }
//
//        return -1;


//Matched solution for leetcode.
                int left = 0;
                int right = nums.length - 1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] > nums[mid + 1]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                return left;

    }
}
