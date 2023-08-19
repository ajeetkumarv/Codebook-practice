package code.mosh.thread.racecondition;

public class DownloadFileTaskWithStatus implements Runnable {

    private DownloadStatus downloadStatus;

    DownloadFileTaskWithStatus(DownloadStatus status) {
        downloadStatus = status;
    }
    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread());

        for (int i=0; i< 10000; i++){
            downloadStatus.incrementBytes();
        }

        System.out.println("Downloading completes for " + Thread.currentThread());
    }
}
