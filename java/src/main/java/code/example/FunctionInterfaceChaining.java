package code.example;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * followed from https://www.youtube.com/watch?v=e4MT_OguDKg&list=WL&index=16
 *
 */
public class FunctionInterfaceChaining {
    public static void main(String[] args) {
        Function<String, String> finalFunction = chain(
                (s) -> s.toLowerCase(),
                (s) -> mask(s),
                (s) -> s.concat(" gen:" + LocalDateTime.now()),
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

    private static String mask(String data) { return "Masked(" + data.replaceAll("id","X") + ")";}
    private static String encrypt(String data) {
        return "Encrypted(" + data + ")";
    }
    private static String compress(String data) {
        return "Compressed(" + data + ")";
    }
}
