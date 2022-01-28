package code.example.interfaces;

public interface Fly {
    default void takeoff() {
        System.out.println("Fly: takeoff");
    }
    default void turn() {
        System.out.println("Fly: turn");
    }
    default void cruise() {
        System.out.println("Fly: cruise");
    }
    default void land() {
        System.out.println("Fly: land");
    }
}