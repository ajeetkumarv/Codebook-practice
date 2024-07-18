package algo.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonCharsTest {

	CommonChars commonChars = new CommonChars();

	@Test
	public void findSmallestElement() {
		commonChars.findCommonChars(new String[]{"ab", "def", "avgt", "adfasfasdfasfasdf"});
	}

}