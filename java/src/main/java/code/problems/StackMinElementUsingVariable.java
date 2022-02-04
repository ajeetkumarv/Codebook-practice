package code.problems;

import java.util.Stack;

/**
 * This is not fully developed class
 */
public class StackMinElementUsingVariable {

    private Stack<Integer> stack = new Stack<>();

    private Integer minElement;

    public void push(Integer element) {

        if (stack.empty()) {
            minElement = element;
            stack.push(element);
        }

        if (element < minElement) {
            Integer encoded = 2 * element - minElement;
            stack.push(encoded);
            minElement = element;
        }
    }

    public Integer pop() {

        Integer element = stack.pop();

        if (element < minElement) {
            int decoded = 2 * minElement - element;
            minElement = decoded;
            return decoded;
        }

        return element;
    }

    public Integer getMin() {
        return minElement;
    }

    public static void main(String[] args) {
        StackMinElementUsingVariable minStack = new StackMinElementUsingVariable();

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
