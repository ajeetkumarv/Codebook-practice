package code.example.thread;

public class ThreadStopDemo {

    public static void main(String[] args) {
        //Thread.currentThread().isInterrupted();
    }

}

class MyTask implements Runnable {
    @Override
    public void run() {
        for (int i=0;i< 10_000;i++) {

            doSimethingLongWithNumber(i);

            // It's our responsibility to keep polling to check if it is interrupted
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("I got interrupted. Stopping");
                return;
            }
        }
    }

    private void doSimethingLongWithNumber(int i) {
    }
}