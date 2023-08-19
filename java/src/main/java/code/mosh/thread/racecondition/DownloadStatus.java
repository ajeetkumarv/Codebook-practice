package code.mosh.thread.racecondition;

public class DownloadStatus {
    private int totalBytes; // making this volatile will improve the situation slightly, not fix it

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementBytes() {
        this.totalBytes++;
    }
}
