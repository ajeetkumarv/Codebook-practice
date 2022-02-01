package code.stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
 */
public class StockSpan {

    int[] data = {100, 80, 60, 70, 60, 75, 85};

    @Test
    public void solve() {

        Stack<Pair> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        //100, 80, 60, 70, 60, 75, 85
        for (int i = 0; i< data.length; i++) {
            if (stack.empty()) {
                result.add(-1);
            } else if (stack.peek().getNum() > data[i]) {
                result.add(stack.peek().getIndex());
            } else {
                while (!stack.empty() && stack.peek().getNum() <= data[i]) {
                    stack.pop();
                }

                if (stack.empty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek().getIndex());
                }
            }

            stack.push(Pair.of(data[i], i));
        }

        System.out.println("Data: " + Arrays.toString(data));
        System.out.println("Indx: " + result);
        for (int i=0;i< data.length;i++) {
            result.set(i, i - result.get(i));
        }
        System.out.println("Count:" + result);
    }

    private static class Pair {
        int num, index;
        private Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }

        static Pair of(int num, int index) {
            return new Pair(num, index);
        }

        int getNum() { return num;}
        int getIndex() { return index;}

        @Override
        public String toString() {
            return "Pair{" +
                    "num=" + num +
                    ", index=" + index +
                    '}';
        }
    }
}
