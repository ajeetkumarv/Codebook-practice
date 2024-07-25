package code.otherrepo.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CallStreamMultipleTimes {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2);

        Stream<Integer> strm = list.stream();
        strm.onClose(() -> System.out.println("Stream closed"));
        strm.forEach(System.out::println);

        //when to call this method https://www.baeldung.com/java-stream-close
        strm.close(); // this will not throw already operated upon or close exception
        // calling strm here will result in java.lang.IllegalStateException: stream has already been operated upon or closed
        //strm.forEach(System.out::println);

        //Using here to not pollute the method names in class if required only in here
        //Using this to call stream again and again to reuse
        Supplier<Stream<Integer>> strmSupplier = () -> list.stream();

        Stream<Integer> s1 = strmSupplier.get();
        s1.forEach(System.out::println);

        Stream<Integer> s2 = strmSupplier.get();
        s2.forEach(System.out::println);

    }


}
