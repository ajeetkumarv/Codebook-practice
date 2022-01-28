package code.executearoundmethodpattern;

class Resource {
    public Resource() {
        System.out.println("Creating...");
    }
    void op1() {System.out.println("Some Operation 1...");}
    void op2() {System.out.println("Some Operation 2...");}
    //never depend on below method gc is not assured to be called at regular intervals
    public void finalize() {System.out.println("External resource cleaned up...");}
}

public class Java5 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.op1();
        resource.op2();
        //cleanup ??
        //we can explicitly have close() and do not forget to cally and use finally block

        //Java 7 introduced: ARM Automatic resource managment OR Try with resource
        //to use above feature, class must implement Autoclosable

    }
}
