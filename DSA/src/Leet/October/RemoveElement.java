package Leet.October;

/*
Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int value = 2;
        System.out.println(removeElement(arr,value));
    }

    public static int removeElement(int[] nums, int val){

        int n = nums.length;
        int i;
        int j=n-1;
        int swapVal=0;

        for (i=0; i<n; i++){
            if (nums[i] == val) swapVal++;
        }

        i=0;
        while (i<j){
           while (nums[i] != val && i<j){
               i++;
           }
           while (nums[j] == val && i<j){
               j--;
           }
           if (i>=j){
               break;
           }
           swap(nums,i,j);
        }
        return n-swapVal;
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }
}

