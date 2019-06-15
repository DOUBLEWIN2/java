package ly.Stack;

import ly.Stack.impl.ArrayStack;
import ly.Stack.impl.LinkedStack;

public class Test {
    public static void main(String[] args) {

        Stack<Integer> stack=new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());

    }

}
