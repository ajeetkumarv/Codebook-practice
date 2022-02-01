package code.stack;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 */
public class NearestLargerElement {

    int data[] = {1,3,0,0,2,4};

    /** O(n^2)
     */
    @Test
    public void nearestGreaterToRightBruteForce() {

        List<Integer> result = Lists.newArrayList();

        for (int i = 0;i < data.length-1;i++) {
            for (int j = i+1;j < data.length;j++) {
                if (data[i] < data[j]) {
                    result.add(data[j]);
                    break;
                }
            }
        }

        result.add((-1));

        for (int i=0;i< data.length;i++) {
            System.out.println("Data: " + data[i] + " nearest greater num: " + result.get(i));
        }

    }

    @Test
    public void nearestGreaterToRightUsingStack() {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = data.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result.add(-1);
            } else if (data[i] < stack.peek()) {
                result.add(stack.peek());
            } else {
                while (!stack.isEmpty() && data[i] >= stack.peek()) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
            }

            stack.push(data[i]);
        }

        Collections.reverse(result);

        System.out.println(Arrays.toString(data));
        System.out.println(result);
    }

    @Test
    public void nearestGreaterToLeftUsingStack() {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        //[1, 3, 0, 0, 2, 4]
        for (int i = 0; i < data.length; i++) {
            if (stack.isEmpty()) {
                result.add(-1);
            } else if (data[i] < stack.peek()) {
                result.add(stack.peek());
            } else {
                while (!stack.empty() && data[i] >= stack.peek() ) {
                    stack.pop();
                }

                if (stack.empty())
                    result.add(-1);
                else
                    result.add(stack.peek());
            }

            stack.push(data[i]);
        }

        System.out.println(Arrays.toString(data));
        System.out.println(result);
    }
}
