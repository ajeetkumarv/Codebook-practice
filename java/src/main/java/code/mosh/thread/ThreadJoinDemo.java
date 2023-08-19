package code.mosh.thread;

import java.util.Arrays;
import java.util.List;

public class ThreadJoinDemo {
    public static void main(String[] args) {

        List<Thread> downloadThreads = Arrays.asList(
                new Thread(new DownloadFileTask()),
                new Thread(new DownloadFileTask()),
                new Thread(new DownloadFileTask()),
                new Thread(new DownloadFileTask()),
                new Thread(new DownloadFileTask())
        );

        downloadThreads.stream().forEach(t -> t.start());

        for (Thread downloadThread: downloadThreads) {
            try {
                /* stop Main thread until downloadThread completes. */
                /* if there are 10 threads all must join. */
                downloadThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All files are downloaded ready to be scanned.");
    }

}
