package string;

import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 */
public class LongestParenthesis {

    private static int getLongestParenthesisLength(String input) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.add(-1);
        for (int i = 0; i < input.length(); i++ ) {
            if ( input.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if ( stack.isEmpty())
                    stack.push(i);
                else
                    maxLength = Math.max(maxLength,  i - stack.peek());
            }
        }

        return maxLength;

    }
    public static void main(String args[]) {
        System.out.println(getLongestParenthesisLength(")()())"));


    }

}
