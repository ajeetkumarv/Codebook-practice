package algo.array;

public class MissingNumbers {

	public int[] findMissingTwoNums(int[] array) {
		int[] missingTwoNums = {-1, -1};

		int totalExpectedSum = sumTill(array.length+2);
		int currentSum = 0;

		for (int num: array) {
			currentSum = currentSum + num;
		}

		int difference = totalExpectedSum - currentSum;

		int avgMissingNumber = difference / 2;

		int curr1stHalfSum = 0;
		int curr2ndHalfSum = 0;

		for (int num: array) {
			if (num <= avgMissingNumber)
				curr1stHalfSum += num;
			else
				curr2ndHalfSum += num;
		}

		int exp1stHalfSum = sumTill(avgMissingNumber);
		int exp2ndHalfSum = 0;

		for (int i = avgMissingNumber + 1 ; i < array.length + 3; i++) {
			exp2ndHalfSum = exp2ndHalfSum + i;
		}

		missingTwoNums[0] = exp1stHalfSum - curr1stHalfSum;
		missingTwoNums[1] = exp2ndHalfSum - curr2ndHalfSum;

		return missingTwoNums;
	}

	private int sumTill(int num) {
		return num * (num + 1) / 2;
	}

}
