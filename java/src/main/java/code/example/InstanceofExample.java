package code.example;

public class InstanceofExample {
	public static void main(String[] args) {
		Number number = 5;
		Integer integer = 5;
        /*
        if (number instanceof String) {}        // clearly number can't be a String... ERROR
        if (number instanceof Integer) {}       // number can be Integer
        if (integer instanceof Integer) {}      // integer is integer, fine
        if (integer instanceof Integer data) {} // BUT don't try to use it with expression :-)

        if (number instanceof List) {}          // number can't be List... but Java won't show error
        if (number instanceof List data) {}     // ...
        */
	}
}
