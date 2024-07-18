package algo.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntereavingStringsTest {
	IntereavingStrings intereavingStrings = new IntereavingStrings();

	@Test
	public void test() {
		boolean result = intereavingStrings.test(
				"algoexpert",
				"your-dream-job",
				"your-algodream-expertjob"
		);

		assertTrue(result);
	}

	@Test
	public void test2() {
		boolean result = intereavingStrings.test(
				"aacaaaa",
				"aaaaaacbaaaaaa",
				"aaabaaa"
		);

		assertFalse(result);
	}

	@Test
	public void test3() {
		boolean result = intereavingStrings.test(
				"algoexpert",
				"your-dream-job",
				"ayloguore-xdpreeratm-job"
		);

		assertTrue(result);
	}

	@Test
	public void test4() {
		boolean result = intereavingStrings.test(
				"aacaaaa",
				"aaabaaa",
				"aaaabacaaaaaaa"
		);

		assertTrue(result);
	}

}