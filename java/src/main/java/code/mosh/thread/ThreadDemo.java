package code.mosh.thread;

public class ThreadDemo {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }

        System.out.println("Started all downloads");

    }
}
