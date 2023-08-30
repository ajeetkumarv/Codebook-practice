package code.algods;

import java.util.Stack;

public class TransactionalStackWorking {

    class TransactionalState  {
        Stack<Integer> stack;

        @Override
        public String toString() {
            return "stack=" + stack;
        }
    }

    private Stack<Integer> stack = new Stack<>();

    private Stack<TransactionalState> states = new Stack<>();

    public void push(int value) {
        if (states.empty()) {
            stack.push(value);
            return;
        }

        states.peek().stack.push(value);
    }

    public int top() {
        // no transaction
        if (states.empty()) {
            return stack.empty() ? 0 : stack.peek();
        }

        // now we have some transaction
        return states.peek().stack.empty() ? 0 : states.peek().stack.peek();
    }

    public void pop() {
        if (states.empty()) { // no transaction
            if (!stack.empty())
                stack.pop();

            return;
        }

        // means there is a transaction
        if (!states.peek().stack.empty())
            states.peek().stack.pop();
    }

    public void begin() {
        TransactionalState newTransactionState = new TransactionalState();
        newTransactionState.stack = new Stack<>();
        if (states.empty()) {
            newTransactionState.stack.addAll(stack);
        } else {
            TransactionalState intermediateState = states.peek();
            newTransactionState.stack.addAll(intermediateState.stack);
        }

        states.push(newTransactionState);
    }

    public boolean rollback() {
        if (states.empty())
            return false;

        TransactionalState currState = states.pop();
        return true; // did a rollback
    }

    public boolean commit() {
        if (states.empty()) {
            return false;
        }

        TransactionalState currState = states.pop();

        if (states.empty()) {
            stack = currState.stack;
            return true;
        }

        states.peek().stack = currState.stack;

        return true; // empty => no open transaction -> false || non empty => has transactions -> true
    }

    @Override
    public String toString() {
        return "TransactionalStackCopyArray{" +
                "stack=" + stack +
                ", states=" + states +
                '}';
    }

    public static void main(String[] args) {
        // Define your tests here
        TransactionalStackWorking sol = new TransactionalStackWorking();
        sol.push(42);
        assert sol.top() == 42 : "top() should be 42";

        sol.begin();

        sol.push(5);
        sol.push(55);
        sol.push(555);

            sol.begin();
            sol.pop();
            sol.pop();

            System.out.println(sol);
            sol.rollback();

        sol.commit();

        System.out.println(sol);



    }
}
