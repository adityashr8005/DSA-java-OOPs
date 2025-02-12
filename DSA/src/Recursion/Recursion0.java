package Recursion;

//Taking about function.
//main is the first function to run in a program.
//while the function is not finished the executing, it remains in stack.
//when the function finished executing, it was removed from stack, and flow goes back to where it had called from.

//Recursion call(function call itself)
//if you are calling fun again and again,you can treat it as a separate call in stack.
//Every called function with different argument will have the same memory in stack.

//The condition where recursion stop is known as base condition.
//If there is no base condition, it reaches stackOverFlow.

//Uses
//It helps in solving a complex problem.
//You can convert a recursion solution into an iteration solution.
//Space complexity is not constant because of function call.
public class Recursion0 {
    public static void main(String[] args) {
        print(1);
    }
    static void print(int n){
        //base condition
        if(n==5){
            System.out.println(5);
            return;
        }
        System.out.println(n);
        //Tail recursion.
        print(n+1);
    }
}
