package code.example.thread.pattern.producerconsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implement Producer Consumer pattern using wait-notify
 * https://www.youtube.com/watch?v=UOr9kMCCa5g
 */
public class UsingLocksDemo {

    public static void main(String[] args) throws InterruptedException {

        MyBlockingQueue queue = new MyBlockingQueue(10);

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

        private Lock lock = new ReentrantLock(true);
        private Condition notEmpty = lock.newCondition();
        private Condition notFull = lock.newCondition();

        MyBlockingQueue(int size) {
            if (size <= 0) {
                size = 10;
            }
            this.size = size;
        }

        public void put(Integer item) {
            lock.lock();
            try {
                while (queue.size() == size) { // if was used here but that had thread issue
                    notFull.await();
                }
                queue.add(item);
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public Integer take() {
            lock.lock();
            try {
                while (queue.isEmpty()) { // if was used here but that had thread issue
                    notEmpty.await();
                }
                Integer element = queue.poll();
                notFull.signalAll();
                return element;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return null;
        }

    }

}
