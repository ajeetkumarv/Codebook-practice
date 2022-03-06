package code.problem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductOfArrayElement {

    @Test
    public void testN2() {
        int[] data = {5, 1, 4, 2};
        int[] output = new int[4];

        for (int i=0;i< data.length;i++) {
            int rp = 1;
            for (int j = 0;j< data.length;j++) {
                if (i != j) {
                    rp = rp * data[j];
                }
            }
            output[i] = rp;
        }

        System.out.println("Result: " + Arrays.toString(output));

    }

    @Test
    public void testOn() {
        int[] data = {5, 1, 4, 2};
        int[] output = new int[4];

        int leftProd = 1;

        for (int i = 0;i< data.length;i++) {
            output[i] = leftProd;
            leftProd = leftProd * data[i];
        }

        int rightProd = 1;
        for (int i = data.length - 1; i > -1; i--) {
            output[i] = output[i] * rightProd;
            rightProd = rightProd * data[i];
        }

        System.out.println("Result: " + Arrays.toString(output));
    }

    @Test
    public void testOnAnother() {
        int[] data = {5, 1, 4, 2};
        int[] output = new int[4];


        System.out.println("Result: " + Arrays.toString(output));
    }
}
