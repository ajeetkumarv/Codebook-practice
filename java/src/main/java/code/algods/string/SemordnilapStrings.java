package code.algods.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SemordnilapStrings {
    public static void main(String[] args) {
        String[] words = {"diaper", "abc", "test", "cba", "repaid"};
        Set<String[]> output = new HashSet<>();

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        for (String word: words) {
            String reverseWord = new StringBuilder(word).reverse().toString();

            if (uniqueWords.contains(reverseWord) && !word.equals(reverseWord)) {
                output.add(new String[] {word, reverseWord});

                uniqueWords.remove(word);
                uniqueWords.remove(reverseWord);
            }

        }

        output.stream().forEach(e -> System.out.println(Arrays.toString(e)));

    }
}
