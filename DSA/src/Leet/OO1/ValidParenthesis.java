package Leet.OO1;

import java.util.Stack;
public class ValidParenthesis {
    public static void main(String[] args) {
        String input = "{[()]";
//        if (isValid(input)) {
//            System.out.println("The string has valid parentheses.");
//        } else {
//            System.out.println("The string does not have valid parentheses.");
//        }
        System.out.println(isValid(input));
    }
    static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
