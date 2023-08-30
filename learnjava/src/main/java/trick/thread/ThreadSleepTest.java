package trick.thread;

public class ThreadSleepTest {

    private static boolean done;
    public static void main(String[] args) throws InterruptedException {
         done  = false;

        new Thread(() -> {
            System.out.println("Starting thread...");

            int count = 0;
            while(!done) {
                count ++;
                //Just remove this sleep and it won't terminate
                //try { Thread.sleep(0);}  catch (Exception e) {}
                //adding volatile also fixes the problem
            }

            System.out.println("Exiting thread...");
        }).start();

        System.out.println("In main, stopping for 2 seconds");

        Thread.sleep(2000);
        done = true;
        System.out.println("Existing main");
    }
}
