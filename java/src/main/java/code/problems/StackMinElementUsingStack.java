package code.problems;

import java.util.Stack;

public class StackMinElementUsingStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer element) {

        //if duplicates are expected then use <=
        if (stack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }

        stack.push(element);
    }

    public Integer pop() {
        Integer element = stack.pop();
        if (element.equals(minStack.peek())) {
            minStack.pop();
        }
        return element;
    }

    public Integer getMin() {
        if (minStack.empty()) {
            return -1;
        }

        return minStack.peek();
    }

    public static void main(String[] args) {
        StackMinElementUsingStack minStack = new StackMinElementUsingStack();

        System.out.println("When empty " + minStack.getMin());

        minStack.push(5);
        System.out.println("When 1 element " + minStack.getMin());

        minStack.push(6);
        System.out.println("When 2 element " + minStack.getMin());
        minStack.push(2);
        System.out.println("When 3 element " + minStack.getMin());

        minStack.pop();
        minStack.push(6);
        System.out.println("When popped " + minStack.getMin());

    }

}
