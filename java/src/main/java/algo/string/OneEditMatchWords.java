package algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OneEditMatchWords {

    private static Set<Integer> expectedSizes = Set.of(1, 0);
    public static void main(String[] args) {

        System.out.println(oneEditPossibleToMatch("hello", "olleg"));
        System.out.println(oneEditPossibleToMatch("hello", "hollo"));
        System.out.println(oneEditPossibleToMatch("hello", "hllo"));
        System.out.println(oneEditPossibleToMatch("bb", "a"));
        System.out.println(oneEditPossibleToMatch("hello", "heloos"));
        System.out.println(oneEditPossibleToMatch("hello", "ellos"));
    }

    private static boolean oneEditPossibleToMatch(String stringOne, String stringTwo) {
        // This is buggy, doesnot work for "hello", "ellos"), bcdefghijklmnopqrstuvwxyz", abdefghijklmnopqrstuvwxyz
        int sizeDiff = Math.abs(stringOne.length() - stringTwo.length());

        if (sizeDiff > 1) {
            return false;
        }

        List<Character> oneChars = stringOne.codePoints().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> twoChars = stringTwo.codePoints().mapToObj(c -> (char) c).collect(Collectors.toList());

        List<Character> oneCharBkp = new ArrayList<>(oneChars);

        remove(oneChars, twoChars);
        remove(twoChars, oneCharBkp);

        return expectedSizes.contains(oneChars.size()) && expectedSizes.contains(twoChars.size());
    }

    private static void remove(List<Character> removeFromIt, List<Character> removeThese) {
        for (Character c: removeThese) {
            removeFromIt.remove(c);
        }
    }
}
