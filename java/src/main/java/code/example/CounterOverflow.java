package code.example;

import java.math.BigInteger;

public class CounterOverflow {

    private int count;

    public synchronized int getCount() {

        Enum e ;

        /*
            this way it will stop at max value
            and won't start with -ve values
         */
        if (count == Integer.MAX_VALUE)
            throw new IllegalStateException("Max value reached");

        return count++;
    }


    // better way
    private BigInteger counter;

    public int getCounter() {
        counter.add(BigInteger.ONE);
        return counter.intValueExact();
    }
}
