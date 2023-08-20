package code.mosh.thread.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ProductPriceTransformationDemo {
    public static void main(String[] args) {
        var priceFuture = CompletableFuture.supplyAsync(() -> "20USD")
                .thenApply(priceWithCurr -> {
                    var priceStr = priceWithCurr.replace("USD", "");
                    return Integer.valueOf(priceStr);
                });
        var exchangeRateFuture = CompletableFuture.supplyAsync(() -> 0.9);

        // first param here means wait for exchangeRateFuture to complete
        priceFuture.thenCombine(exchangeRateFuture, (price, exchangeRate) -> price * exchangeRate)
                .thenAccept(rate -> System.out.println(rate));
    }
}
