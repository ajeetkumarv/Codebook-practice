package code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysExceptionDemo {

    @Test
    public void testHeterogenousArray() {
        Object[] o = {Boolean.TRUE, Integer.MIN_VALUE, new Object(), "STR"};
        for (int i=0;i< o.length;i++) {
            System.out.println(o[i]);
        }
    }

    @Test
    public void testArrayStoreException() {
        Number[] n = new Double[1];

        // THis is depricated against valueOf method for performance reason
        // this throws ArrayStoreException
        try {
            n[0] = new Integer(9);
        } catch (ArrayStoreException e) {
            //
        }
    }
}
