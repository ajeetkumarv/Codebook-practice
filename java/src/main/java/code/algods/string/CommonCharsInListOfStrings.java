package code.algods.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TODO
public class CommonCharsInListOfStrings {
    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "cbad"};
        strings = commonChars1(strings);

        System.out.println(Arrays.toString(strings));
    }

    /**
     * choose smallest string, find unique chars, potential output
     * remove chars in potential outpute by scanning absent chars in other lists
     */
    private static String[] commonChars1(String[] strings) {

        String smallestStr = findSmallestStr(strings);

        Set<Character> potentialChars = new HashSet<>();
        smallestStr.codePoints().mapToObj( c -> (char)c).distinct().forEach(c -> potentialChars.add(c));

        for (String str: strings) {
            Set<Character> characterSet = str.codePoints().mapToObj(c -> (char) c).distinct().collect(Collectors.toSet());
            Set<Character> toRemove = new HashSet<>();
            for (Character c: potentialChars) {
                if (!characterSet.contains(c)) {
                    toRemove.add(c);
                }
            }

            toRemove.stream().forEach(c -> potentialChars.remove(c));
        }

        return potentialChars.stream()
                .map(c -> String.valueOf(c))
                .toList()
                .toArray(new String[0]);
    }

    private static String findSmallestStr(String[] strings) {
        String smallest = strings[0];

        for (String str: strings) {
            if (smallest.length() > str.length()) {
                smallest = str;
            }
        }

        return smallest;
    }

    /**
     * maintain a map of char and count by first creating unique char set.
     * if char count matches the count of strings that means present in all strings.
     */
    private static String[] commonChars2(String[] strings) {

        return null;
    }
}
