package code.otherrepo.trick;

public class FinalizeTest {
    public static void main(String[] args) throws Throwable {

        FinalizeTest f = new FinalizeTest();
        //f.finalize();
        System.gc();

        Thread.sleep(2000);

        System.out.println("End of main");
    }

    @Override
    protected void finalize() throws Throwable {
        //super.finalize();
        System.out.println("Finalizing");
    }
}
