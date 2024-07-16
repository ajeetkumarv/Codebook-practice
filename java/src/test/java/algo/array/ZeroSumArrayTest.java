package algo.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ZeroSumArrayTest {

	ZeroSumArray zeroSumArray = new ZeroSumArray();

	@Test
	public void test() {
		boolean zeroSum = zeroSumArray.findZeroSum(new int[]{-5, -5, 2, 3, -2});
		System.out.println(zeroSum);
	}

}