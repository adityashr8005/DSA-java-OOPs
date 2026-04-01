package Leet.Year2026.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
There are n 1-indexed robots, each having a position on a line, health, and movement direction.

You are given 0-indexed integer arrays positions, healths, and a string directions
(directions[i] is either 'L' for left or 'R' for right). All integers in positions are unique.

All robots start moving on the line simultaneously at the same speed in their given directions.
If two robots ever share the same position while moving, they will collide.

If two robots collide, the robot with lower health is removed from the line, and the health of the other robot decreases by one.
The surviving robot continues in the same direction it was going. If both robots have the same health,
they are both removed from the line.

Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given,
i.e. final health of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors,
return an empty array.

Return an array containing the health of the remaining robots (in the order they were given in the input),
after no further collisions can occur.

Note: The positions may be unsorted.

Example 1:
Input: positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
Output: [2,17,9,15,10]
Explanation: No collision occurs in this example, since all robots are moving in the same direction.
So, the health of the robots in order from the first robot is returned, [2, 17, 9, 15, 10].

Example 2:
Input: positions = [3,5,2,6], healths = [10,10,15,12], directions = "RLRL"
Output: [14]
Explanation: There are 2 collisions in this example. Firstly, robot 1 and robot 2 will collide,
and since both have the same health, they will be removed from the line.
Next, robot 3 and robot 4 will collide and since robot 4's health is smaller, it gets removed,
and robot 3's health becomes 15 - 1 = 14. Only robot 3 remains, so we return [14].

Example 3:
Input: positions = [1,2,5,6], healths = [10,10,11,11], directions = "RLRL"
Output: []
Explanation: Robot 1 and robot 2 will collide and since both have the same health, they are both removed.
Robot 3 and 4 will collide and since both have the same health, they are both removed. So, we return an empty array, [].


Constraints:
1 <= positions.length == healths.length == directions.length == n <= 10^5
1 <= positions[i], healths[i] <= 10^9
directions[i] == 'L' or directions[i] == 'R'
All values in positions are distinct
 */
public class RobotCollisons {
    public static List<Integer> survivedRobotHealths(int[] positions, int[] healths, String directions){
        int n = positions.length;
        ArrayList<Integer> result = new ArrayList<>();

//        int[] newArr = Arrays.copyOf(positions,n);
//        Arrays.sort(newArr);
        int[][] newArr = new int[n][2];
        for (int i=0; i<n; i++){
            newArr[i][0] = positions[i];
            newArr[i][1] = i;
        }

        Arrays.sort(newArr, (a, b) -> a[0] - b[0]);

        Stack<Integer> st = new Stack<>();

        for (int i=0; i<n; i++){
            int j = newArr[i][1];

            if (directions.charAt(j) == 'R'){
                st.push(j);
            }else {
                while (!st.isEmpty() && healths[j]>0){
                    int topIndex = st.peek();

                    if (healths[j] < healths[topIndex]){
                        healths[j] = 0;
                        healths[topIndex] -= 1;
                    } else if (healths[j] > healths[topIndex]) {
                        st.pop();
                        healths[j] -= 1;
                        healths[topIndex] = 0;
                    }else {
                        st.pop();
                        healths[j] = 0;
                        healths[topIndex] = 0;
                    }
                }

            }
        }

        for (int i=0; i<n; i++){
            if (healths[i] != 0) result.addLast(healths[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";

        System.out.println(survivedRobotHealths(positions,healths,directions));
    }
}
