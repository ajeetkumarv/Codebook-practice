package code.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolSubmitTest {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        es.submit(new Thread()); // this accepts Runnable

        es.shutdown();
    }

    static class Thread implements Runnable {

        @Override
        public void run() {
            try {
                /*
                This was point of trick during Morgan Stanley test
                Since the class name is Thread, you don't have currentThread() method
                so it was a miss from me :(
                 */
                //System.out.println("TEst" + Thread.currentThread());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
