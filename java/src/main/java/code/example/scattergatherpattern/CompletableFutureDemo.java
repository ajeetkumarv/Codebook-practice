package code.example.scattergatherpattern;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        Set<Integer> prices = Collections.synchronizedSet(new HashSet<>());

        CompletableFuture<Void> first = CompletableFuture.runAsync(new PriceFetchTask("url1", "1", prices));
        CompletableFuture<Void> second = CompletableFuture.runAsync(new PriceFetchTask("url2", "1", prices));
        CompletableFuture<Void> third = CompletableFuture.runAsync(new PriceFetchTask("url3", "1", prices));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(first, second, third);
        allOf.get(3, TimeUnit.SECONDS);

        System.out.println("Final fetched prices: " + prices);
    }
}
