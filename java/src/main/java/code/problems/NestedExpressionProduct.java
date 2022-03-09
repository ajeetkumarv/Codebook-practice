package code.problems;

import java.util.*;

class NestedExpressionProduct {

    public static void main(String[] args) {


        //System.out.println("Result: " + productSum(data));
    }

    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.
    public static int productSum(List<Object> array) {
        // Write your code here.

        int sum = 0;
        int level = 1;

        for (Object item: array) {
            sum = sum + processForSum(item, level);
        }

        return sum;
    }

    private static int processForSum(Object item, int level) {
        if (item instanceof Integer) {
            int val = (Integer) item;
            return val * level;
        }

        int sum = 0;
        List<Object> list = (List<Object>) item;
        for (Object obj: list) {
            sum = sum + processForSum(obj, level + 1);
        }

        level--;
        return sum;
    }
}
