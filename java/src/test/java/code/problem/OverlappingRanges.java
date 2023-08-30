package code.problem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingRanges {

    @Test
    public void mergeOverlaps() {
        //Integer[][] data = {{1, 3},{2, 6}, {6, 7}, {8, 10},{15, 18}};
        //Integer[][] data = {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        int[][] data = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};

        Arrays.sort(data, Comparator.comparingInt(a -> a[0]));

        for (int[] e: data) {
            System.out.println(">>" + Arrays.toString(e));
        }

        List<int[]> result = new ArrayList<>();

        int i = 0;

        while (i <= data.length - 1) {
            int leftVal = data[i][0];
            int rightVal = data[i][1];

            while (i < data.length -1 && data[i+1][0] <= rightVal) {
                if (rightVal < data[i+1][1])
                    rightVal = data[i+1][1];
                i++;
            }

            result.add(new int[]{leftVal, rightVal});
            i++;
        }

        int[][] arrayResult = result.toArray(new int[0][0]);

        for (int[] e: arrayResult) {
            System.out.println(">" + Arrays.toString(e));
        }
    }

}
