package code.example.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeDemo {

    public static void main(String[] args) {

        //between number 1 and 50 prime or not
        IntStream.range(1, 51)
                .forEach(n -> System.out.println(n + " is prime " +  isPrime(n)));

        //first 50 prime numbers
        List<Double> sqrtOffiftyPrimes = IntStream.iterate(1, e -> e + 1)
                .filter(n -> isPrime(n))
                .boxed()
                .map(Math::sqrt)
                .limit(50)
                .collect(Collectors.toList());

        System.out.println("First fifty primes: " + sqrtOffiftyPrimes);


    }

    private static boolean isPrime(int n) {
        return n > 1 && IntStream.range(2, n).noneMatch(i -> n % i == 0);
    }

}
