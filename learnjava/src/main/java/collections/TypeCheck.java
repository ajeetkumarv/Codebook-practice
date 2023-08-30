package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TypeCheck {
    public static void main(String[] args) {
        List<Integer> d1 = new ArrayList<>();
        List<Integer> d2 = new LinkedList<>();

        System.out.println(d1.getClass());
        System.out.println(d2.getClass());
    }
}

