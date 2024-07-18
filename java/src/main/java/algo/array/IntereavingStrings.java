package algo.array;

public class IntereavingStrings {

	public boolean test(String one, String two, String three) {

		int i= 0, j=0, k=0;

		if (three.length() != one.length() + two.length())
			return false;

		for (; k < three.length() ;k++) {
			char ch = three.charAt(k);
			boolean claimed = false;

			System.out.print(">" + ch + " ");
			if (i < one.length() && ch == one.charAt(i)) {
				System.out.println("[" + ch + "] i=" + i);
				i++;
				claimed = true;
			}

			if (j < two.length() && ch == two.charAt(j)) {
				System.out.println("\t\t{" + ch + "} j=" + j);

				if (claimed && (k+1) < three.length() && (j+1) < two.length() && three.charAt(k+1) == two.charAt(j+1)) {
					i--; // steal
					System.out.print("Steal " + i);
				} else if (claimed && three.charAt(k+1) == two.charAt(j)) {
					k++;
				}

				j++;
				claimed = true;
			}

			if (!claimed) { //for test2()
				System.out.println("==== no claim " + ch +" " + i + " " + j + " " + k);
				break;
			}
		}

		return k == three.length() ;//&& i == one.length() && j == two.length();
	}
}
