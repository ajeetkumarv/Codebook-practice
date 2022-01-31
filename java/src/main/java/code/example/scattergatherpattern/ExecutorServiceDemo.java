package code.example.scattergatherpattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

    static ExecutorService service = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException {


    }

    private static void fetchOptimizedUsingLatch() {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

        CountDownLatch latch = new CountDownLatch(3);

        service.submit(new PriceFetchTask("url1", "1", prices));
        service.submit(new PriceFetchTask("url2", "1", prices));
        service.submit(new PriceFetchTask("url3", "1", prices));

        try {
            latch.await(3, TimeUnit.SECONDS); // waiting for latch count to become 0 within 3 seconds or else open latch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Prices: " + prices);
    }

    private static void fetchPricesMax3Seconds() {
        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

        service.submit(new PriceFetchTask("url1", "1", prices));
        service.submit(new PriceFetchTask("url2", "1", prices));
        service.submit(new PriceFetchTask("url3", "1", prices));

        try {
            Thread.sleep(3000); // flip side of this is if we get all request in mch less time, we wait unnecessary
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Prices: " + prices);
    }

}
