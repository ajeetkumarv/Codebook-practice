package code.mosh.thread;

public class StoppableDownloadFileTask implements Runnable {

    @Override
    public void run() {
        for (int i=0;i< Integer.MAX_VALUE;i++) { // download for iternity
            System.out.println("Downloading..." + i);

            if (Thread.interrupted()) {
                System.out.println("Stopping the download...");
                return;
            }

            /* sleep is not required. I just added it to test what heppens if interrup is received when thread was sleeping. */
            /* so if thread was interrupted when it was sleeping, it gets angry and throws InterrupedException. */
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                System.out.println("Got your messag to stop but I'm sleeping. I'll stop in a while.");
                // reinterrupt itself so that next time it is checked
                Thread.currentThread().interrupt();
            }


        }

    }
}
