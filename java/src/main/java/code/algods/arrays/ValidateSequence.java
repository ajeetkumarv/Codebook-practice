package code.algods.arrays;

import java.util.List;

/**
 * Validate if an array is subsequence of other array.
 * order is important, they may not be together.
 */
public class ValidateSequence {
    public static void main(String[] args) {

        List<Integer> array = List.of(5,1,22,25,6,-1,8,10);
        List<Integer> sequence = List.of(1,6,-1,10);

        System.out.println(isSubsequence(array, sequence));
    }

    public static boolean isSubsequence(List<Integer> array, List<Integer> sequence) {
        int i = 0;
        for (Integer element: array) {
            int expecting = sequence.get(i);

            if (element.equals(expecting)) {
                i++;
            }

            if (i == sequence.size()) { // optimization: if sequence is reached end, return
                return true;
            }
        }

        return i == sequence.size();
    }
}
