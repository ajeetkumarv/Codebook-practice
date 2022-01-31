package code.example.scattergatherpattern;

import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class PriceFetchTask implements Runnable{

    private String url;
    private String productId;
    private Set<Integer> prices;
    private CountDownLatch latch;

    public PriceFetchTask(String url, String productId, Set<Integer> prices) {
        this.url = url;
        this.productId = productId;
        this.prices = prices;
    }

    public PriceFetchTask(String url, String productId, Set<Integer> prices, CountDownLatch latch) {
        this(url, productId, prices);
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Fetching from URL: " + url);
        //fetch from http
        //add to prices set

        //after adding price
        if (latch != null) {
            latch.countDown();
        }
    }
}
