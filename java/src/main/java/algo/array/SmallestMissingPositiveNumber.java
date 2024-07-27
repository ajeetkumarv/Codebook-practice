package algo.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmallestMissingPositiveNumber {
	public static void main(String[] args) {
		Integer[] array = {1,3,6,4,1,2,5};

		Set<Integer> numbers = Arrays.stream(array)
				.filter(n -> n > 0)
				.collect(Collectors.toSet());

		Integer maxNumInArray = Collections.max(numbers);

		Integer firstMissingPositiveNum = Stream.iterate(1, i -> i + 1)
				.filter(n -> !numbers.contains(n))
				.findFirst()
				.get();

		if (firstMissingPositiveNum > maxNumInArray) {
			System.out.println("Array has all nums in sequence");
		}

		System.out.println("Output: " + firstMissingPositiveNum);

	}

}
