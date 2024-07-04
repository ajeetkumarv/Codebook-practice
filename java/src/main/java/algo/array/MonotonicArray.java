package algo.array;

public class MonotonicArray {

	public boolean method1(int[] array) {
		if (array.length == 2) return true;

		int tone = array[1] - array[0];

		for (int i = 2; i < array.length ;i++) {
			int diff = array[i] - array[0];

			if (tone == 0) {
				tone = diff;
				continue;
			}

			if (diff ==0 || tone > 0 ? diff > 0 : diff < 0) {
				continue;
			}

			return false;
		}

		return true;
	}

	public boolean method2(int[] array) {

		boolean isIncreasing = true;
		boolean isDecreasing = true;

		for (int i = 1 ; i < array.length ;i++) {
			if (array[i] > array[i-1]) {
				isDecreasing = false;
			}
			if (array[i] < array[i-1]) {
				isIncreasing = false;
			}
		}

		return isIncreasing || isDecreasing;
	}

	public boolean method3(int[] array) {
		boolean increaseMaintained = true;
		boolean decreaseMaintained = true;

		if (array.length <= 2) return true;

		for (int i = 1; i< array.length ;i++) {
			decreaseMaintained = decreaseMaintained && array[i] <= array[i-1];
			increaseMaintained = increaseMaintained && array[i] >= array[i-1];
		}

		return increaseMaintained || decreaseMaintained;
	}
}
