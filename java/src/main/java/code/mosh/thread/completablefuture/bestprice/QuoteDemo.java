package code.mosh.thread.completablefuture.bestprice;

import code.mosh.thread.completablefuture.LongTask;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class QuoteDemo {
    public static void main(String[] args) {
        //singleQuote();

        var flightService = new FlightService();

        flightService.getQuotes()
                .map(site -> site.thenAccept(System.out::println))
                .toList();

        // waiting so that it doesnt terminate
        LongTask.simulate(10_000);
    }

    private static void singleQuote() {
        var flightService = new FlightService();

        flightService.getQuote("site")
                .thenAccept(System.out::println);

        // waiting so that it doesnt terminate
        LongTask.simulate(10_000);
    }
}
