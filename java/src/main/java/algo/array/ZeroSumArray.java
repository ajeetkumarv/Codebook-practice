package algo.array;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumArray {

	public boolean findZeroSum(int [] array) {
		Set<Integer> historyOfSum = new HashSet<>();
		historyOfSum.add(0);
		int sum = 0;

		for (int num: array) {
			sum = sum + num;
			if (historyOfSum.contains(sum)) {
				return true;
			}
			historyOfSum.add(sum);
		}

		return false;
	}
}
