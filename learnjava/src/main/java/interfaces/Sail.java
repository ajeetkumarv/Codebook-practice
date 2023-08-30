package interfaces;

public interface Sail {
    public default void cruise() {
        System.out.println("Sail: cruise");
    }

    public default void chappu() {
        System.out.println("Sail: chappu");
    }

    public static void staticMethod() {
        System.out.println("Sail:: staticMethod");
    }

}
