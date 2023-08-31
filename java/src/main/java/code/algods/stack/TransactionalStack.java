package code.algods.stack;

import java.util.List;
import java.util.Stack;

public class TransactionalStack {

    private Stack<Integer> stack;

    private Stack<Integer> popHistory;

    private Stack<TransactionalStack> txState;

    private TransactionalStack prevState;

    public TransactionalStack() {
        // Implement your solution here
        stack = new Stack<>();
        txState = new Stack<>();
    }

    private TransactionalStack(TransactionalStack prevState) {
        this();
        this.prevState = prevState;
        this.popHistory = new Stack<>();
    }

    public void push(int value) {
        if (txState.empty()) {
            // no transaction
            stack.push(value);
        } else {
            // topmost transaction
            txState.peek().push(value);
        }
    }

    public int top() {
        // no transaction
        if (txState.empty()) {
            return stack.empty() ? 0 : stack.peek();
        }

        // now we have some transaction
        TransactionalStack currTxState = txState.peek();
        while(currTxState.stack.empty()) {
            currTxState = currTxState.prevState;

            if (currTxState.prevState == null) { // means first stack without transaction
                return stack.empty() ? 0 : stack.peek();
            }
        }

        return currTxState.stack.peek();
    }

    public void pop() {
        if (txState.empty()) { // no transaction
            if (!stack.empty())
                stack.pop();

            return;
        }

        // means there is a transaction
        TransactionalStack currTxState = txState.peek();
        TransactionalStack popHistorForthisState = currTxState;
        while(currTxState.stack.empty()) {
            currTxState = currTxState.prevState;

            if (currTxState.prevState == null) {
                break;
            }
        }

        if (!currTxState.stack.empty()) {
            Integer popped = currTxState.stack.pop();
            popHistorForthisState.popHistory.push(popped);
        }

        // poping where curr tx is empty, so pop from prev stack but may need to rollback this pop

    }

    public void begin() {
        TransactionalStack newTransactionState = new TransactionalStack(this);
        txState.push(newTransactionState);
    }

    public boolean rollback() {
        if (txState.empty())
            return false;


        TransactionalStack currState = txState.pop();

        List<TransactionalStack> list = (List<TransactionalStack>) txState;

        for (int i = 0;i < list.size() ;i++) {
            if (list.get(i).stack.empty()) {
                list.get(i).stack.push(currState.popHistory.pop());
            }
        }


        /*while(!currState.popHistory.empty()) {
            txState.peek().push(currState.popHistory.pop());
        }*/


        return true; // did a rollback
    }

    public boolean commit() {
        if (txState.empty()) {
            return false;
        }

        TransactionalStack currTxState = txState.pop();
        currTxState.getPrevState().stack.addAll(currTxState.stack);

        return !txState.empty(); // empty => no open transaction -> false || non empty => has transactions -> true
    }
    private TransactionalStack getPrevState() {
        return this.prevState;
    }

    public static void main(String[] args) {
        // Define your tests here
        TransactionalStack sol = new TransactionalStack();
        sol.push(42);

        assert sol.top() == 42 : "top() should be 42";
    }
}
