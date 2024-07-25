package code.otherrepo.trick.array;

public class ArrayTest {
    public static void main(String[] args) {
        Object[] o = {Boolean.TRUE, Integer.MIN_VALUE, new Object(),"STR"};
        for (int i=0;i< o.length;i++) {
            System.out.println(o);
        }

        Number[] n = new Double[1];

        // THis is depricated against valueOf method for performance reason
        // this throws ArrayStoreException
        n[0] = new Integer(9);

        Thread t = new Thread(() -> {
            System.out.println("SOmething");
        });

        t.start();
        t.start(); // IllegalThreadStateException

    }
}
