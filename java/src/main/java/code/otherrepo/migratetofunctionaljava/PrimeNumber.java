package code.otherrepo.migratetofunctionaljava;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * this snippet is learned from below url: Transforming code to java
 * https://www.youtube.com/watch?v=wk3WLaR2V2U&t=1693s
 *
 * Topic: Streamlining Iterations
 * External vs Internal Iterators
 * Specialized funcations
 * Function composition
 * Infinite streams
 * Lazy evaluations
 *
 */
public class PrimeNumber {
    public static void main(String[] args) {
        IntStream.range(1, 16).forEach(n -> System.out.println(n + " is prime: " + isPrime(n)));
    }

    /*
     * prime number is a positive integer that has exactly two positive divisors.
     * However, 1 only has one positive divisor (1 itself), so it is not prime.
     */
    private static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch((n)-> number % n == 0);
    }

    private List<Double> sqrtOfFirst100Primes() {
        List<Double> sqrtOfFirst100Primes = Stream
                .iterate(1, e -> e + 1)
                .filter(PrimeNumber::isPrime)
                .map(Math::sqrt)
                .limit(100) // this is also lazy evaluation
                .collect(Collectors.toList());

        return sqrtOfFirst100Primes;

    }

    private List<Number> sqrtOfFirstNPrimes(int n) {
        List<Number> result = IntStream
                .iterate(1, e -> e + 1)
                .filter(PrimeNumber::isPrime)
                .mapToDouble(Math::sqrt)
                .boxed()
                //above call is necessary bcz DoubleStream returned by mapToDouble doesn't support Collectors.toList()
                //or below way to making list as LinkedList
                .collect(Collectors.toCollection(LinkedList::new));
        return result;
    }



}
