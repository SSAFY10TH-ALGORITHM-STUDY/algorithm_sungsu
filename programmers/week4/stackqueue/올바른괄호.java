package programmers.week4.stackqueue;

import java.util.Stack;

/**
 *
 */
public class 올바른괄호 {
    public static void main(String[] args) {
        String str = "(())()";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == ')'){
                if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                else stack.push(c);
            }else{
                stack.push(c);
            }
        }

//        System.out.println(stack.toString());
        if(stack.isEmpty()) System.out.println(true);
        else System.out.println(false);
    }
}
