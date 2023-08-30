package thread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PipelineDemo {

    private static void process(CompletableFuture<Integer> future) {
        future
                .thenApply(d -> d * 2)
                .thenAccept( (d) -> System.out.println("Processing " + d))
                .thenRun(() -> System.out.println("Notifying data"));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        process(completableFuture);
        Thread.sleep(4000);

        completableFuture.complete(5);
    }
}
