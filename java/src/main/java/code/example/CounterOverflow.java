package code.example;

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
}
