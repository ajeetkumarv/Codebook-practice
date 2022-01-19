package code.generics.collections;

import java.util.ArrayList;
import java.util.List;

class Animal {}
class Cat extends Animal {}
class Dog extends Animal {}

public class Demo {

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        //List<Animal> animals = dogs; // not allowed
    }

}
