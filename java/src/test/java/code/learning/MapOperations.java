package code.learning;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapOperations {

    @Test
    public void typeOfValuesMethod() {
        Map<Integer, List<String>> aMap = Map.of(
                1, List.of("one", "One"),
                2, List.of("two", "Two")
        );

        //Notice the type is Collection of List
        Collection<List<String>> values = aMap.values();

        //if i want flattened values
        List<String> allValues = values.stream()
                .flatMap(v -> v.stream())
                .collect(Collectors.toList());

        System.out.println(allValues);
    }

}
