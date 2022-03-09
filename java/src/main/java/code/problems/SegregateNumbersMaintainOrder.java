package code.problems;

import java.util.Arrays;
import java.util.function.BiConsumer;

/**
 * segregate -ve and +ve
 */
public class SegregateNumbersMaintainOrder {


    public static void main(String[] args) {
        int[] data = {-7, -1, 3, 6, 2, 9, -4, -5, -8, 9, 7};

        segregate(data);

        System.out.println("Result: " + Arrays.toString(data));
    }

    private static void segregate(int[] data) {

        int i = 0;
        int holderIndex;
        while (i < data.length) {
            while (i < data.length && data[i] < 0) {
                i++;
            }

            //found a positive number at i
            int holdPositiveNum = data[i];
            holderIndex = i;
            i++;
            //look for next -ve number
            while (i < data.length && data[i] < 0) {
                i++;
            }

        }
    }
}
