package code.example.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class CompletableFutureDemo {

    static ForkJoinPool fjp = new ForkJoinPool(5);

    private void printIt(Integer value) {
        System.out.println(value + " Printing from " + Thread.currentThread());
    }

    private Integer compute() {
        System.out.println("Compute: " + Thread.currentThread());
        return 2;
    }

    private CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    private CompletableFuture<Integer> createInPool(ForkJoinPool fjp) {
        return CompletableFuture.supplyAsync(() -> compute(), fjp);
    }

    public static void main(String[] args) throws Exception {

        CompletableFutureDemo demo = new CompletableFutureDemo();

        System.out.println("Main: " + Thread.currentThread());

        CompletableFuture<Integer> completableFuture = demo.create();
        // printIt may be called by main or ForkJoinPool thread
        // if pool thread if finished before thenAccept then main will be used to invoke it
        completableFuture.thenAccept(demo::printIt);

        if (true) throw new Exception("Breaking");

        System.out.println("-------------RUNNING IN MENTIONED POOL----------------");

        CompletableFuture<Integer> completableFuture1 = demo.createInPool(fjp);
        Integer data = completableFuture1.get();
        System.out.println("From dedicated pool: " + data);

        System.out.println("-------------RUNNING DEMO----------------");

        CompletableFuture<Integer> cf = demo.create();
        cf
            .thenAccept(demo::printIt)
            .thenRun(() -> System.out.println("Something in Runnable"))
            .thenRun(() -> System.out.println("Something again in Runnable"))
        ;

        System.out.println("-------------RUNNING DEMO DELAYED----------------");

        CompletableFuture<Integer> completableFuture2 = demo.create(4000L);
        completableFuture2
                .thenApply((d) -> d * 100)
                .thenAccept(demo::printIt)
                .thenRun(() -> System.out.println("Something in Runnable"))
                .thenRun(() -> System.out.println("Something again in Runnable"))
        ;


        Thread.sleep(6000);
        System.out.println("Main ends");
    }

    private CompletableFuture<Integer> create(Long sleepForSeconds) {
        return CompletableFuture.supplyAsync(() -> compute(sleepForSeconds));
    }

    private Integer compute(Long sleepForSeconds) {
        try {
            Thread.sleep(sleepForSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Compute after seconds: " + sleepForSeconds/1000 + " threads: " + Thread.currentThread());
        return 2;
    }

}