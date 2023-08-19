package code.mosh.thread;

public class StoppableThead {
    public static void main(String[] args) {
        StoppableDownloadFileTask stoppableDownloadFileTask = new StoppableDownloadFileTask();

        Thread downloadThread = new Thread(stoppableDownloadFileTask);

        downloadThread.start();

        try {
            System.out.println("Main thread waiting for 2 seconds");
            Thread.sleep(2000); // Timeout of 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sending interrupr");
        downloadThread.interrupt();
    }
}
