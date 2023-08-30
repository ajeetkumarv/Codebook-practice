package trick;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CharStreamTest {
    public static void main(String[] args) {
        "Hello".chars().forEach(System.out::print);

        class Group {
            private String l;
            private Integer n;
            Group(String l, Integer n) {this.l = l; this.n=n;}
            public String toString() {return String.format("(%s,%d)",l,n);}
        }

        List<String> letters = Arrays.asList("A","B","C","D");
        List<Integer> nums = Arrays.asList(1,2,3);

        List<Group> groups = letters.stream()
                .flatMap(l -> nums.stream()
                        .map(n -> new Group(l, n)))
                .collect(Collectors.toList());

        System.out.println(groups);
    }
}
