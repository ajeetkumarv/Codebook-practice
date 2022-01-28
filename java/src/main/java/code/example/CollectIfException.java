package code.example;

import com.google.common.base.Throwables;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectIfException {

    public static void main(String[] args) {
        List<String> data = Stream.of("A","B","C","D")
                .map(d -> {
                    if (d.equals("D"))
                        throw new NullPointerException(); // NPE wil blast the entire processing
                    return d.toLowerCase();
                })
                .collect(Collectors.toList());

        System.out.println(data);
    }

}
