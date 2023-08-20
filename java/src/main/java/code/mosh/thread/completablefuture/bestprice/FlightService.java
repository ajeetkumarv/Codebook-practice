package code.mosh.thread.completablefuture.bestprice;

import code.mosh.thread.completablefuture.LongTask;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {

    public Stream<CompletableFuture<Quote>> getQuotes() {
        List<String> sites = List.of("site1", "site2", "site3");

        return sites.stream()
                .map(site ->  getQuote(site));
    }

    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int delay = random.nextInt(1, 8) * 1000;
            System.out.println("Getting a quote from " + site + " delayed sec " + delay);
            LongTask.simulate(delay);
            return new Quote(100 + random.nextInt(1, 10), site);
        });
    }
}
