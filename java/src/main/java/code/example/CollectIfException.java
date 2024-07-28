package code.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectIfException {

    public static void main(String[] args) {
        List<String> data = Stream.of("A","B","C","D")
                .map(d -> {
                    if (d.equals("D"))
                        throw new RuntimeException(); // will blast the entire processing
                    return d.toLowerCase();
                })
                .collect(Collectors.toList());

        System.out.println(data);
    }

}
