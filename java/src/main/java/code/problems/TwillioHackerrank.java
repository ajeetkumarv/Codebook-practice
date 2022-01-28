package code.problems;

import java.util.Collections;
import java.util.List;

/**
 * create group of consecutive elements of list of segment size and find max in min of each segment
 * segment will be like shiftring right by 1
 * below solution is wrong understanding of problem, need to implement correct solution
 * https://stackoverflow.com/questions/8499227/minimum-value-of-maximum-values-in-sub-segments-in-on-complexity
 */
public class TwillioHackerrank {

    public static void main(String[] args) {

        System.out.println("Should be 1=" + min(List.of(1), 1));
        System.out.println("Should be 4=" + min(List.of(1, 4, 3), 1));

        System.out.println("Should be 3=" + min(List.of(1, 4, 3, 8), 2));
        System.out.println("Should be 3=" + min(List.of(1, 4, 3), 2));

    }

    private static Integer min(List<Integer> data, Integer segment) {

        if (segment == 1) {
            return Collections.max(data);
        } else if (segment == data.size()) {
            return Collections.min(data);
        }

        Integer maxOfSegmentMins = null;

        for (int subStartIndex = 0; subStartIndex < data.size(); subStartIndex += segment) {
            int subEndIndex = subStartIndex + segment;

            if (subEndIndex > data.size()) {
                subEndIndex = data.size();
            }

            List<Integer> sublist = data.subList(subStartIndex, subEndIndex);
            int minInSegment = Collections.min(sublist);

            if (maxOfSegmentMins == null)
                maxOfSegmentMins = minInSegment;

            if (maxOfSegmentMins < minInSegment) {
                maxOfSegmentMins = minInSegment;
            }
        }

        return maxOfSegmentMins;
    }


}
