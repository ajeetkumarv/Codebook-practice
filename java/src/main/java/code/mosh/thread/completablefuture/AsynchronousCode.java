package code.mosh.thread.completablefuture;

import java.util.concurrent.CompletableFuture;

public class AsynchronousCode {
    public static void main(String[] args) throws InterruptedException {

        var mailService = new MailService();

        CompletableFuture<Void> voidCompletableFuture = mailService.sendAsync();

        System.out.println("Back to main thread");
        voidCompletableFuture.join();

        //Thread.sleep(5000); // to see Mail was sent msg at 3 seconds.
    }

    private static class MailService {
        public void send() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Mail was sent.");
        }

        public CompletableFuture<Void> sendAsync() {
            //This will run in a separate thread
            return CompletableFuture.runAsync(() -> send());
        }
    }
}
