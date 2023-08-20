package code.mosh.thread.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        getUserEmailAsync()
                .thenCompose(email -> getPlaylistAsync(email))
                .thenAccept(playlist -> System.out.println(playlist));

    }

    public static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "sample@gmail.com"); // fetching email from db
    }

    public static CompletableFuture<List<String>> getPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> playlist()); // fetching playlist from db
    }

    private static List<String> playlist() {
        return List.of("song1", "song2", "song3");
    }
}
