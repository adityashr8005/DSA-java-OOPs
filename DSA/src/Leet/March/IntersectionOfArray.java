package Leet.March;

/*
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */
import java.util.Arrays;
import java.util.Hashtable;

public class IntersectionOfArray {
    public static void main(String[] args) {
        int[] num1={4,9,5};
        int[] num2={9,4,9,8,4};
        int[] ans=intersection(num1,num2);
        System.out.println(Arrays.toString(ans));
    }
    static int[] intersection(int[] nums1, int[] nums2){
        Hashtable<Integer,Integer> hash = new Hashtable<>();
        int k=0;
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length; j++){
                if (nums1[i]==nums2[j] && (!hash.contains(nums1[i]))){
                    hash.put(k++,nums2[j]);
                }
            }
        }
        int[] new_arr=new int[hash.size()];

        for (int i=0; i< hash.size(); i++){
            new_arr[i] = hash.get(i);
        }
        return new_arr;
    }
}
