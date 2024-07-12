package algo.array;

public class ArrayOfProducts {

	public static int[] method(int [] array) {

		int [] products = new int[array.length];
		int [] leftProds = new int[array.length];
		int [] rightProds = new int[array.length];

		int leftRunningProds = 1;
		for (int i=0;i<products.length;i++) {
			leftProds[i] = leftRunningProds;
			leftRunningProds = leftRunningProds * array[i];
		}

		int rightRunningProds = 1;
		for (int i= array.length-1; i >= 0; i--) {
			rightProds[i] = rightRunningProds;
			rightRunningProds = rightRunningProds * array[i];
		}

		for (int i= array.length-1; i >= 0; i--) {
			products[i] = leftProds[i] * rightProds[i];
		}

		return products;
	}

	public static void main(String[] args) {
		method(new int[] {5,1,4,2});
	}
}
