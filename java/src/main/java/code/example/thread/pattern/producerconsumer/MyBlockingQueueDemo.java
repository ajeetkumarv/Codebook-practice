package code.example.thread.pattern.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implement Producer Consumer pattern using wait-notify
 * https://www.youtube.com/watch?v=UOr9kMCCa5g
 */
class MyBlockingQueue {

    private Queue<Integer> queue = new LinkedList<>();
    private int size = 10;

    private Lock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    MyBlockingQueue(int size) {
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

public class MyBlockingQueueDemo {

    public static void main(String[] args) {

    }

}
