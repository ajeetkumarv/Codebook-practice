package code.executearoundmethodpattern;

class Resource7 implements AutoCloseable {
    public Resource7() {
        System.out.println("Creating...");
    }
    void op1() {System.out.println("Some Operation 1...");}
    void op2() {System.out.println("Some Operation 2...");}

    /**
     * Notice this is not throwing Exception as marked in superclass
     */
    @Override
    public void close() {System.out.println("External resource cleaned up...");}
}

public class Java7 {
    public static void main(String[] args) {

        try (var resource = new Resource7()) {
            resource.op1();
            resource.op2();
        }
        //Java 7 introduced: ARM Automatic resource managment OR Try with resource
        //to use above feature, class must implement Autoclosable

    }
}