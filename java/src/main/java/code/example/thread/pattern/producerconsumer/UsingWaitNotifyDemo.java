package code.example.thread.pattern.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implement Producer Consumer pattern using wait-notify
 * https://www.youtube.com/watch?v=UOr9kMCCa5g
 */
public class UsingWaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {

        MyBlockingQueue queue = new MyBlockingQueue();

        Runnable producer = () -> {
            while(true) {
                Integer item = createItem();
                queue.put(item);
                if (item == null)
                    break;

                System.out.println("Producing: " + item);
            }
            System.out.println("Stopped Producing");
        };

        Runnable consumer = () -> {
            while(true) {
                Integer item = queue.take();
                if (item == null)
                    break;

                System.out.println("Consuming: " + item);
            }
            System.out.println("Stopped Consuming");
        };

        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
        new Thread(consumer).start();


        //Thread.sleep(3000);
        System.out.println("main thread ended");
    }

    private static Queue<Integer> toBeSupplied = IntStream.iterate(1, e -> e + 1)
            .limit(100)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));

    private static Integer createItem() {
        return toBeSupplied.poll();
    }

    private static class MyBlockingQueue {

        private Queue<Integer> queue = new LinkedList<>();
        private int size = 10;

        //private Object readLock = new Object();
        //private Object writeLock = new Object();

        MyBlockingQueue() {}

        public synchronized void put(Integer item) {
            try {
                while (queue.size() == size) {
                    //writeLock.wait();
                    this.wait();
                }
                queue.add(item);
                //readLock.notifyAll();
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized Integer take() {
            try {
                while (queue.isEmpty()) {
                    //readLock.wait();
                    this.wait();
                }
                Integer element = queue.poll();
                //writeLock.notifyAll();
                this.notifyAll();
                return element;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

    }
}
