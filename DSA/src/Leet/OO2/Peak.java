package Leet.OO2;

public class Peak {
    public static void main(String[] args) {
        int[] arr = {24,101,100,99,79,78,67,36,26,19,12};
//        int[] arr = {1,2,3,4,5,6,7,8,9,1};
        int ans = peakIndex(arr);
        System.out.println(ans);
    }
    static int peakIndex(int[] arr){
        //More time consuming
//        int max = 0;
//        int s = 0;
//        int e = arr.length-1;
//        int ans1=0;
//       int ans = peak(arr,max,s,e);
//        if (arr[ans]<arr[ans-1]){
//            ans1 = peak(arr, ans - 1, s, ans);
//            while(arr[ans1]<arr[ans1-1]) {
//                ans1 = peak(arr, ans1 - 1, s, ans1);
//            }
//            return ans1;
//        }
//     return ans;
//    }
//    static int peak(int[] arr, int max, int s, int e){
//        while (arr[max]<arr[max+1]){
//            int mid = s + (e-s) /2;
//            if (arr[mid]<arr[mid+1]){
//                max=mid+1;
//                s=mid;
//            }else if (arr[mid]<arr[mid-1]){
//                max=mid-1;
//                e=mid;
//            }else{
//                max=mid;
//            }
//        }
//        return max;


        //Less time-consuming
        int start = 1;
        int end = arr.length-2;

        while(start <= end) {
            int mid = (start + end)/2;
            boolean left = arr[mid] > arr[mid-1];
            boolean right = arr[mid] > arr[mid+1];

            if(left && right) {
                return mid;
            }

            else if (arr[mid-1] > arr[mid]) {
                end = mid-1;
            }

            else {
                start = mid+1;
            }
        }

        return -1;
    }
}
