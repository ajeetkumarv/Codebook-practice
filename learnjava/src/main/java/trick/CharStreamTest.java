package trick;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharStreamTest {
    public static void main(String[] args) {
        "Hello".chars()
                .mapToObj( c -> (char)c)
                .forEach(System.out::print);

        class Group {
            private String l;
            private Integer n;
            Group(String l, Integer n) {this.l = l; this.n=n;}
            public String toString() {return String.format("(%s,%d)",l,n);}
        }

        class Trio {
            private String l;
            private Integer n;
            private Character c;

            Trio(String l, Integer n, Character c) {
                this.l = l;
                this.n = n;
                this.c = c;
            }
            public String toString() {return String.format("(%s,%d,%s)",l,n,c);}
        }

        List<String> letters = Arrays.asList("A","B","C","D");
        List<Integer> nums = Arrays.asList(1,2,3);
        List<Character> chars = Arrays.asList('-','/','_');

        List<Group> groups = letters.stream()
                .flatMap(l -> nums.stream()
                        .map(n -> new Group(l, n)))
                .collect(Collectors.toList());

        var trio = letters.stream()
                        .flatMap(l -> nums.stream()
                                .flatMap(n -> chars.stream()
                                        .map( c -> new Trio(l, n, c)))
                                )
                .toList();

        System.out.println(groups);
        System.out.println(trio);
    }
}
