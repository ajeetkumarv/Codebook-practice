package code.example;

import java.util.function.Supplier;

public class ExceptionFromFunctional {
	Supplier<Integer> supplier = () -> {
		throw new RuntimeException("Exception from functional");
	};

	public static void main(String[] args) {
		ExceptionFromFunctional exceptionFromFunctional = new ExceptionFromFunctional();
		try {
			exceptionFromFunctional.supplier.get();
		} catch (Exception e) {
			System.out.println("Caught exception: " + e.getMessage());
		}
	}
}
