package Leet.Year2026.March;


import java.util.*;

/*
Given an array of strings nums containing n unique binary strings each of length n,
return a binary string of length n that does not appear in nums.
If there are multiple answers, you may return any of them.

Example 1:
Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.

Example 2:
Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.

Example 3:
Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 */
public class UniqueBinaryString {

    //Method 1.
//    public  static String findDifferentBinaryString(String[] nums){
//
//        int n = nums.length;
//        String result = "";
//        for (int i=0; i<n; i++){
//            if (nums[i].charAt(i) == '0'){
//                result += "1";
//            }else {
//                result += "0";
//            }
//        }
//        return result;
//    }

    //Method 2
    public static String findDifferentBinaryString(String[] nums){
        List<Integer> set = new ArrayList<>();

        int n = nums.length;
        String result;

        for (String num : nums){
            set.add(Integer.parseInt(num,2));
        }

        for (int num=0 ; num<=n; num++){
            for (int i=0; i< set.size(); i++){
                if (num != set.get(i)){
                    String withSpaces = String.format("%" + n + "s", Integer.toBinaryString(num)); //000000101010
                    result = withSpaces.replace(" ", "0");
                    return result;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        String ans =  findDifferentBinaryString(nums);
        System.out.println(ans);
    }
}
