package Leet.April;

/*
Example 1:
Input: nums = [1,3]
Output: 6
Explanation: The 4 subsets of [1,3] are:
- The empty subset has an XOR total of 0.
- [1] has an XOR total of 1.
- [3] has an XOR total of 3.
- [1,3] has an XOR total of 1 XOR 3 = 2.
0 + 1 + 3 + 2 = 6

Example 2:
Input: nums = [5,1,6]
Output: 28
Explanation: The 8 subsets of [5,1,6] are:
- The empty subset has an XOR total of 0.
- [5] has an XOR total of 5.
- [1] has an XOR total of 1.
- [6] has an XOR total of 6.
- [5,1] has an XOR total of 5 XOR 1 = 4.
- [5,6] has an XOR total of 5 XOR 6 = 3.
- [1,6] has an XOR total of 1 XOR 6 = 7.
- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
 */
public class SumOfSubsetXOR {
    public static void main(String[] args){
        int[] arr = {3,4,5,6,7,8};
        System.out.println(subsetXORsum(arr));
    }
    static int subsetXORsum(int[] nums){

        int i=0;
        int add=nums[0];

        //Applied OR operator to individual elements.
        while (i<nums.length-1){
            add |= nums[i + 1];
            i++;
        }

        //Multiplying it with 2^n-1.
        return add * (int)Math.pow(2,nums.length-1);
    }
}
