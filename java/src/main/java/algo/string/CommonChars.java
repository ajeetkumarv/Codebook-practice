package algo.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Common Characters
 * Write a function that takes in a non-empty list of non-empty strings and returns a list of characters that are common to all strings in the list, ignoring multiplicity.
 *
 * Note that the strings are not guaranteed to only contain alphanumeric characters. The list you return can be in any order.
 *
 * Sample Input
 * strings = ["abc", "bcd", "cbaccd"]
 * Sample Output
 * ["b", "c"] // The characters could be ordered differently.
 */
public class CommonChars {

	public String[] findCommonChars(String[] array) {

		String smallestStr = Arrays.stream(array)
				.min((s1, s2) -> s1.length() < s2.length()? -1 : 1)
				.get();

		Set<String> potentialCommonChars = smallestStr.chars()
				.mapToObj(c -> String.valueOf(c))
				.collect(Collectors.toSet());

		Set<String> toRemove = new HashSet<>();

		for (String str: array) {
			for (String c: potentialCommonChars) {
				if (!str.contains(c)) {
					toRemove.add(c);
				}
			}

			potentialCommonChars.removeAll(toRemove);
			toRemove.clear();
		}

		return potentialCommonChars.stream().map(c -> String.valueOf(c)).toList().toArray(new String[0]);
	}
}
