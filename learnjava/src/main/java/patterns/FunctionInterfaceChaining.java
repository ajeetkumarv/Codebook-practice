package patterns;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionInterfaceChaining {
    public static void main(String[] args) {
        Function<String, String> finalFunction = chain(
                (s) -> s.toLowerCase(),
                (s) -> s.replaceAll("id","X"),
                (s) -> s.concat(" gen:" + LocalDateTime.now().toString()),
                (s) -> FunctionInterfaceChaining.encrypt(s),
                (s) -> FunctionInterfaceChaining.compress(s)
        );

        var data = finalFunction.apply("id: 123");
        System.out.println("Final data: " +  data);
    }

    /**
     * This works only if function takes and returns of same type
     * @param functions
     * @return
     */
    private static Function<String, String> chain(Function<String, String> ... functions) {
        return Stream.of(functions)
                .reduce(s -> s, (f1, f2) -> f1.andThen(f2));
                // or .reduce(Function.identity(), Function::andThen);

    }

    private static String encrypt(String data) {
        return "Encrypted(" + data + ")";
    }
    private static String compress(String data) {
        return "Compressed(" + data + ")";
    }
}
