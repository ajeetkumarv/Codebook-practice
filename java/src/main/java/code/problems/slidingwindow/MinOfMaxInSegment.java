package code.problems.slidingwindow;

import java.util.*;

public class MinOfMaxInSegment {

    Integer[] data;
    Integer segment;

    MinOfMaxInSegment(Integer[] data, Integer segment) {
        this.data = data;
        this.segment = segment;
    }

    Integer[] maxOfSegments() {
        List<Integer> maxOfEachSegment = new ArrayList<>();

        int i = 0, j = 0;
        System.out.println(Arrays.toString(data));

        int maxIndex = 0;

        while (j < segment) {
            if (data[maxIndex] < data[j]) {
                maxIndex = j;
            }
            j++;
        }

        maxOfEachSegment.add(data[maxIndex]);
        int minOfMaxInSegment = data[maxIndex];

        while (j < data.length) {
            System.out.println("Window Index: " + i + ", " + j + " data: "
                    + Arrays.toString(Arrays.copyOfRange(data, i, j))
                    + " Max Index: " + maxIndex
                    + " Max Data: " + data[maxIndex]);

            if (data[j] > data[maxIndex] || (maxIndex > i && data[maxIndex] < data[j])) {
                maxIndex = j;
            } else { // this means max number is being out of windows now
                int k = i + 1;
                maxIndex = k;
                while(k <= j) {
                    if (data[maxIndex] < data[k]) {
                        maxIndex = k;
                    }
                    k++;
                }

            }
            maxOfEachSegment.add(data[maxIndex]);

            if (minOfMaxInSegment > data[maxIndex]) {
                minOfMaxInSegment = data[maxIndex];
            }

            //slide right
            if (j >= segment - 1) {
                i++;
            }
            j++;
        }
        System.out.println("Min of Max of segments is: " + minOfMaxInSegment);
        return maxOfEachSegment.toArray(new Integer[maxOfEachSegment.size()]);
    }

    public static void main(String[] args) {
        Integer[] data = {1, 3, -1, -3, 5, 3, 6, 7};
        MinOfMaxInSegment finder = new MinOfMaxInSegment(data, 3);
        System.out.println("Result " + Arrays.toString(finder.maxOfSegments()));

        data = new Integer[]{9, 3, -1, -3, 5, 3, 6, 7};

        finder = new MinOfMaxInSegment(data, 3);
        System.out.println("Result " + Arrays.toString(finder.maxOfSegments()));
    }

}
