package algo.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumbersTest {

	MissingNumbers missingNumbers = new MissingNumbers();

	@Test
	public void test1() {
		int[] array = {1, 4, 3};

		int[] missingTwoNums = missingNumbers.findMissingTwoNums(array);

		System.out.println("Result: " + Arrays.toString(missingTwoNums));
	}

}