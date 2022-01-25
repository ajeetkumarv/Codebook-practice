package code.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ClosingStreamDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2);

        Stream<Integer> strm = list.stream();
        strm.onClose(() -> System.out.println("Stream closed"));
        strm.forEach(System.out::println);

        //when to call this method https://www.baeldung.com/java-stream-close
        strm.close(); // this will not throw already operated upon or close exception
        // calling strm here will result in java.lang.IllegalStateException: stream has already been operated upon or closed
        //strm.forEach(System.out::println);
    }

}
