package code.learning;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.*;

public class FunctionalInterfaces {

    @Test
    public void operatorExample() {
        UnaryOperator<Integer> addTen = i -> i + 10;
        BinaryOperator<Integer> multiplyTimes = (i, times) -> i * times;

        Assertions.assertEquals(15, addTen.apply(5));
        Assertions.assertEquals(50, multiplyTimes.apply(5, 10));
    }

    @Test
    public void functionInterfacesTypes() {
        Predicate<Integer> isEven = i -> i % 2 == 0;
        assertEquals(true, isEven.test(6));

        Function<String, Integer> countChar = str -> str.length();
        assertEquals(5, countChar.apply("sample"));

        Consumer<String> show = str -> System.out.println("The data is: " + str);
        show.accept("Sample");

        Supplier<Integer> random = () -> new Random().nextInt();
        Integer anyNum = random.get();
    }

}
