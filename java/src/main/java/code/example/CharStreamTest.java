package code.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharStreamTest {
    public static void main(String[] args) {

        //This gives IntStream, it doesn't print individual chars
        "Hello".chars().forEach(c -> System.out.print(c + "_"));

        class Pair {
            String a, b;
            Pair(String a, String b) { this.a = a; this.b = b;}
            public String toString() {return "(" + a + ", " + b + ")";}
        }

        System.out.println("Creating combination");

        List<String> letters = List.of("A", "B", "C", "D");
        List<Integer> nums = List.of(1, 2, 3);

        List<Pair> grouped = letters.stream()
                .flatMap(l -> nums.stream().map(n -> new Pair(l, n.toString())))
                .collect(Collectors.toList());

        System.out.println(grouped);
    }
}
