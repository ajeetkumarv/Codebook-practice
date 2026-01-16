package concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBufer<T> {
    private Queue<T> queue = new ArrayDeque<>();
    private int capacity;

    private Lock lock = new ReentrantLock();
    private Condition becomeNotFull = lock.newCondition(); // producer will wait to buffer become not full
    private Condition becomeNotEmpty = lock.newCondition(); // consumer will wait for buffer to become not empty

    public BoundedBufer(int capacity) {
        this.capacity = capacity;
    }

    public void put(T value) throws InterruptedException {
        lock.lock();

        try {
            while(queue.size() == capacity) {
                becomeNotFull.await();
            }

            queue.add(value);
            becomeNotEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();

        try {
            while(queue.isEmpty()) {
                becomeNotEmpty.await();
            }

            T value = queue.poll();
            becomeNotFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private BoundedBufer<Long> buf;
    public Producer(BoundedBufer<Long> buf) {
        this.buf = buf;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 20; i++) {
                long produce = Math.round(Math.random());
                this.buf.put(produce);
                System.out.println("Produce: " + produce);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer implements Runnable {
    private BoundedBufer<Long> buf;
    public Consumer(BoundedBufer<Long> buf) {
        this.buf = buf;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 20; i++) {
                long consume = buf.take();
                System.out.println("Consume: " + consume);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ProducerConsumerWithLock {
    public static void main(String[] args) {
        BoundedBufer<Long> buffer = new BoundedBufer<>(50);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
