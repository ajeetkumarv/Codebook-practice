package code.example.thread.pattern.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class UsingBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        AtomicInteger counter = new AtomicInteger();
        Runnable producer = () -> {
            try {
                while(true) {
                    queue.put(counter.incrementAndGet());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
            try {
                while(true) {
                    Integer item = queue.take();
                    System.out.println("Consuming: " + item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(consumer).start();
        new Thread(consumer).start();


        Thread.sleep(3000);

    }



}
