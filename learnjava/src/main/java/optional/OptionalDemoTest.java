package optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemoTest {
    public static void main(String[] args) {
        Optional<String> optional1 = Optional.empty();
        Optional<String> optional2 = Optional.of("Anything");

        String data = "Something";
        String nullData = null;

        Optional<String> optional3 = Optional.of(data);

        //This throws NullPointerException
        //Optional<String> optional4 = Optional.of(nullData);
        Optional<String> optional5 = Optional.ofNullable(nullData);
        System.out.println("Created using null data, Checking isPresent: " + optional5.isPresent());
        System.out.println("Default value test: " + optional5.orElse("DEFAULT_DATA"));

        //if present do first thing, if absent do that runnable
        optional5.ifPresentOrElse(String::toUpperCase, () -> System.out.println("Data empty"));

        Optional<String> possibleNullData = Optional.empty();
        //possibleNullData.orElseThrow();//throws NoSuchElementException
        //possibleNullData.orElseThrow(IllegalStateException::new);

        Optional<Customer> cust = Optional.of(new Customer("Sample"));
        cust.map(Customer::getName).orElse("NOT FOUND");
    }
}
