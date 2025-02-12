package Recursion;

/*
     1)Identify if you can break down problems into a smaller problem.
     2)Write the recurrence relation if needed. (fib(n-1)+fib(n-2))
     3)Draw the recursive tree.
     4)About the tree
          *See the flow of functions, how they are getting in stack.
          *Identify and follow on left tree calls and right tree calls.
          *Draw the tree and pointer again and again using pen and paper.
          *Use a debugger to see the flow.
     5)See how the value is returned at each step.
       See where the function call will come out.
       End you will come out of the main function.


 */
public class Fibonacii {
    public static void main(String[] args) {
       int ans = fibo(4);
        System.out.println(ans);

        //To get the 50th fibonacci number, we use the formula.
        System.out.println(fiboFormula(4));
    }
    static int fiboFormula(int n){
        return (int) (Math.pow(((1+Math.sqrt(5))/2),n) / Math.sqrt(5));
    }

    static int fibo(int n){
        //Base condition
        if (n==1){
            return 0;
        } else if (n==2) {
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
