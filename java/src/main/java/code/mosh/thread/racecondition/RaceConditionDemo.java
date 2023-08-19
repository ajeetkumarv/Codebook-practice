package code.mosh.thread.racecondition;

import java.util.ArrayList;
import java.util.List;

public class RaceConditionDemo {
    public static void main(String[] args) {
        var status = new DownloadStatus();//shared resource;

        List<Thread> threads = new ArrayList<>();

        for (int i=0;i< 10;i++) {
            Thread thread = new Thread(new DownloadFileTaskWithStatus(status));
            thread.start();
            threads.add(thread);
        }

        for (Thread t: threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total bytes: " + status.getTotalBytes());
    }
}
