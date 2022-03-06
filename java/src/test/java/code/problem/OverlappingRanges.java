package code.problem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingRanges {

    @Test
    public void mergeOverlaps() {
        Integer[][] data = {{1, 3},{2, 6}, {6, 7}, {8, 10},{15, 18}};
        Integer[][] required = {{1, 7}, {8, 10}, {15, 18}};

        List<Integer[]> result = new ArrayList<>();

        int i = 0;

        while (i <= data.length - 1) {
            int leftVal = data[i][0];
            int rightVal = data[i][1];

            while (i < data.length -1 && data[i+1][0] <= rightVal) {
                rightVal = data[i+1][1];
                i++;
            }

            result.add(new Integer[]{leftVal, rightVal});
            i++;
        }

        Integer[][] arrayResult = result.toArray(new Integer[0][0]);

        for (Integer[] e: arrayResult) {
            System.out.println(">" + Arrays.toString(e));
        }
    }

}
