package Leet.April;

/*
Question number 11 (Greedy)
Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: Array represents the above vertical lines [1,8,6,2,5,4,8,3,7]. In this case,
             the max area of water (blue section) the container can contain is 49.
             Maximum height gain is 8 but doesn't give maximum area. So, max height taken
             is 7 of index 8 which gives maximum area.
Example 2:
Input: height = [1,1]
Output: 1

Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] array = {1,2,1};
        System.out.println(maxArea(array));
    }
    static int maxArea(int[] height){

        int max=0,max_Area=0, i;
        int high = height[0];
        int length = 1;

        for (i=1; i<height.length; i++){
            int maximum;

            if (high>height[i]){
                high=height[i];
            }
            if (height[max]<height[i]){
                max=i;
            }
            maximum=high * (i-max);
            if (maximum>max_Area){
                max_Area=maximum;
            }
            high=height[max];
        }
        return max_Area;
    }
}
