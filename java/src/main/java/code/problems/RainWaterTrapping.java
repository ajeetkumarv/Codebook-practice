package code.problems;

import java.util.Arrays;
import java.util.Collections;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] data = {3, 0, 0, 2, 0, 4};

        int[] leftMax = new int[data.length];
        int[] rightMax = new int[data.length];

        int maxIndex = data.length - 1;

        leftMax[0] = data[0];
        rightMax[maxIndex] = data[maxIndex];

        for (int i = 1; i < data.length; i++) {
            leftMax[i] = Integer.max(leftMax[i-1], data[i]);
        }

        for (int i = maxIndex; i > 0; i--) {
            rightMax[i-1] = Integer.max(data[i-1], rightMax[i]);
        }

        int[] mins = new int[data.length];

        for (int i = 0; i < mins.length; i++) {
            mins[i] = Integer.min(leftMax[i], rightMax[i]);
        }

        System.out.println("Left max" + Arrays.toString(leftMax));
        System.out.println("Right max" + Arrays.toString(rightMax));
        System.out.println("Mins" + Arrays.toString(mins));

        for (int i = 0; i < mins.length; i++) {
            mins[i] = mins[i] - data[i];
        }

        System.out.println("Units of water stored: " + Arrays.toString(mins));
        System.out.println("Area of water stored: " + Arrays.stream(mins).sum());
    }
}
