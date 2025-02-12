package Leet.OO1;
//Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator

public class DivideTwoInteger {
    //Below is the detail explanation.

    static int divide(int dividend, int divisor){

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Corner case when -2^31 is divided by -1 will give 2^31 which doesnt exist so overflow

        boolean negative = dividend < 0 ^ divisor < 0; //Logical XOR will help in deciding if the results is negative only if any one of them is negative

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;

        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return negative ? -quotient : quotient;
    }
    public static void main(String[] args) {

        int dividend = 214748;
        int divisor = 2;
        int ans = divide(dividend,divisor);
        System.out.println(ans);

//        boolean result = -5<0 ^ 2<0;
//        System.out.println(result);
    }
}



/*
1.Handling the corner case:

java
if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
This line checks if the dividend is the minimum possible integer value (-2^31) and the divisor is -1. If so, it returns Integer.MAX_VALUE because dividing -2^31 by -1 would result in 2^31, which exceeds the maximum value an integer can hold, causing an overflow.

2.Determining the sign of the result:

java
boolean negative = dividend < 0 ^ divisor < 0;
This line uses the logical XOR operator (^) to determine if the result should be negative. The result is negative if only one of dividend or divisor is negative.

3.Taking the absolute values:
 dividend = Math.abs(dividend);
 divisor = Math.abs(divisor);
These lines convert both dividend and divisor to their absolute values to simplify the division process.

4.Initializing variables:
int quotient = 0, subQuot = 0;
These lines initialize the quotient and subQuot variables. quotient will store the final result, and subQuot will be used in the inner loop.

5.Performing the division:

while (dividend - divisor >= 0) {
        for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
quotient += 1 << subQuot;
dividend -= divisor << subQuot;
}
The outer while loop continues as long as the dividend is greater than or equal to the divisor.

The inner for loop finds the largest power of 2 (1 << subQuot) such that divisor * (1 << subQuot) is less than or equal to the dividend. This is done by left-shifting the divisor and checking if it is still less than or equal to the dividend.

After finding the appropriate subQuot, the quotient is incremented by 1 << subQuot.

The dividend is then reduced by divisor * (1 << subQuot).

6.Returning the result:

return negative ? -quotient : quotient;
Finally, the code returns the quotient. If the result should be negative (as determined earlier), it returns -quotient; otherwise, it returns quotient.
*/



//Step 5. in detail with example.
/*

dividend = 27

divisor = 3

while (dividend - divisor >= 0) {
    for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
    quotient += 1 << subQuot;
    dividend -= divisor << subQuot;
}
Step-by-Step Explanation

Initial Values:
dividend = 27
divisor = 3
quotient = 0
subQuot = 0

First Iteration of the Outer while Loop:
dividend - divisor = 27 - 3 = 24 (which is >= 0, so we enter the loop)

First Iteration of the Inner for Loop:
subQuot = 0: dividend - (divisor << subQuot << 1) = 27 - (3 << 0 << 1) = 27 - 6 = 21 (which is >= 0)
subQuot = 1: dividend - (divisor << subQuot << 1) = 27 - (3 << 1 << 1) = 27 - 12 = 15 (which is >= 0)
subQuot = 2: dividend - (divisor << subQuot << 1) = 27 - (3 << 2 << 1) = 27 - 24 = 3 (which is >= 0)
subQuot = 3: dividend - (divisor << subQuot << 1) = 27 - (3 << 3 << 1) = 27 - 48 = -21 (which is < 0, so we exit the loop)

Update quotient and dividend:
quotient += 1 << subQuot = 0 + (1 << 2) = 0 + 4 = 4
dividend -= divisor << subQuot = 27 - (3 << 2) = 27 - 12 = 15
|
|
Second Iteration of the Outer while Loop:
dividend - divisor = 15 - 3 = 12 (which is >= 0, so we enter the loop)

Second Iteration of the Inner for Loop:
subQuot = 0: dividend - (divisor << subQuot << 1) = 15 - (3 << 0 << 1) = 15 - 6 = 9 (which is >= 0)
subQuot = 1: dividend - (divisor << subQuot << 1) = 15 - (3 << 1 << 1) = 15 - 12 = 3 (which is >= 0)
subQuot = 2: dividend - (divisor << subQuot << 1) = 15 - (3 << 2 << 1) = 15 - 24 = -9 (which is < 0, so we exit the loop)

Update quotient and dividend:
quotient += 1 << subQuot = 4 + (1 << 1) = 4 + 2 = 6
dividend -= divisor << subQuot = 15 - (3 << 1) = 15 - 6 = 9
|
|
Third Iteration of the Outer while Loop:
dividend - divisor = 9 - 3 = 6 (which is >= 0, so we enter the loop)

Third Iteration of the Inner for Loop:
subQuot = 0: dividend - (divisor << subQuot << 1) = 9 - (3 << 0 << 1) = 9 - 6 = 3 (which is >= 0)
subQuot = 1: dividend - (divisor << subQuot << 1) = 9 - (3 << 1 << 1) = 9 - 12 = -3 (which is < 0, so we exit the loop)

Update quotient and dividend:
quotient += 1 << subQuot = 6 + (1 << 0) = 6 + 1 = 7
dividend -= divisor << subQuot = 9 - (3 << 0) = 9 - 3 = 6
|
|
Fourth Iteration of the Outer while Loop:
dividend - divisor = 6 - 3 = 3 (which is >= 0, so we enter the loop)

Fourth Iteration of the Inner for Loop:
subQuot = 0: dividend - (divisor << subQuot << 1) = 6 - (3 << 0 << 1) = 6 - 6 = 0 (which is >= 0)
subQuot = 1: dividend - (divisor << subQuot << 1) = 6 - (3 << 1 << 1) = 6 - 12 = -6 (which is < 0, so we exit the loop)

Update quotient and dividend:
quotient += 1 << subQuot = 7 + (1 << 0) = 7 + 1 = 8
dividend -= divisor << subQuot = 6 - (3 << 0) = 6 - 3 = 3
|
|
Fifth Iteration of the Outer while Loop:
dividend - divisor = 3 - 3 = 0 (which is >= 0, so we enter the loop)

Fifth Iteration of the Inner for Loop:
subQuot = 0: dividend - (divisor << subQuot << 1) = 3 - (3 << 0 << 1) = 3 - 6 = -3 (which is < 0, so we exit the loop)

Update quotient and dividend:
quotient += 1 << subQuot = 8 + (1 << 0) = 8 + 1 = 9
dividend -= divisor << subQuot = 3 - (3 << 0) = 3 - 3 = 0
|
|
Exit the Outer while Loop:
dividend - divisor = 0 - 3 = -3 (which is < 0, so we exit the loop)

Final Result
The final quotient is 9, which means 27 / 3 = 9.
 */
