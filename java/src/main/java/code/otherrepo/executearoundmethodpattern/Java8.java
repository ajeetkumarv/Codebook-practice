package code.otherrepo.executearoundmethodpattern;

import java.util.function.Consumer;

class Resource8 {
    private Resource8() { // prevent other user to create classes
        System.out.println("Creating...");
    }
    void op1() {System.out.println("Some Operation 1...");}
    void op2() {System.out.println("Some Operation 2...");}
    public void close() {System.out.println("External resource cleaned up...");}

    /**
     * this way making sure close will be called. it is not dependent on
     * other programmers to not forget to call close()
     * @param block
     */
    public static void use(Consumer<Resource8> block) {
        Resource8 resource  = new Resource8();
        try {
            block.accept(resource); // providing implementation of op1 and op2
        } finally {
            resource.close();
        }
    }
}

public class Java8 {
    public static void main(String[] args) {
        //this is also called Loan pattern
        //this is inspired by synchronized block working, thread enters, does the job and releases
        //learned form url: https://www.youtube.com/watch?v=wk3WLaR2V2U&t=1693s
        //Title: transforming code to java 8

        Resource8.use(resource -> {
            resource.op1();
            resource.op2();

            //if I changed it to happen like resource.op1().op2()
            //its called trained wreck pattern also call cascade method
        });
    }
}
