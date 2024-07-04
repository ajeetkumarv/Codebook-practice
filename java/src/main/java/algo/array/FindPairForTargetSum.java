package algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairForTargetSum {

	public int[] findOnePair(int[] array, Integer targetSum) {

		Set<Integer> history = new HashSet<>();

		for (Integer num: array) {
			if (history.contains(targetSum - num)) {
				return new int[] {num, targetSum - num};
			}

			history.add(num);
		}

		return new int[]{};
	}

	public Integer[][] findAllPairs(int[] array, Integer targetSum) {

		Set<Integer> history = new HashSet<>();

		Set<Integer[]> allPairs = new HashSet<>();

		for (Integer num: array) {
			if (history.contains(targetSum - num)) {
				allPairs.add(new Integer[] {num, targetSum - num});
			}

			history.add(num);
		}

		return allPairs.toArray(new Integer[0][]);
	}

	private static Integer[][] findPairWithTargetSumSortedArrayApproach(int[] array, int targetSum) {
		Arrays.sort(array);

		List<Integer[]> pairs = new ArrayList<>();

		for (int i=0, j =array.length - 1; i < j;) {
			int sum = array[i] + array[j];

			if (sum == targetSum) {
				pairs.add(new Integer[] {array[i], array[j]});
				i++;
				j--;
			} else if ( sum < targetSum) {
				i++;
			} else {
				j--;
			}
		}

		return pairs.toArray(new Integer[0][]);
	}
}
