package code;

import com.google.common.collect.Lists;

import java.util.List;

public class MainTestClass {

    public static void main(String[] args) {
        System.out.println("This is a learning code project");

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
