package code.problems;

import java.util.Stack;
import java.util.stream.Stream;

public class ReverseStackRecursion {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stream.iterate(1, e -> e + 1)
                .limit(5)
                .forEach(stack::push);

        System.out.println("Before: " + stack);
        reverse(stack);
        System.out.println("After: " + stack);
    }

    static void reverse(Stack<Integer> stack) {

        if (!stack.empty()) {
            Integer item = stack.pop();
            System.out.println("We have " + item);
            reverse(stack);

            reinsert(item, stack);
        }
    }

    static void reinsert(Integer item, Stack<Integer> stack) {
        if (stack.empty()) {
            stack.push(item);
        } else {
            Integer element = stack.pop();
            reinsert(item, stack);

            stack.push(element);
        }
    }

}
