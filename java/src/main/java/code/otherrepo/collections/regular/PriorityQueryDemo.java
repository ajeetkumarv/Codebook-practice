package code.otherrepo.collections.regular;

import java.util.PriorityQueue;

public class PriorityQueryDemo {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Orange");
        pq.add("Mango");
        pq.add("Apple");

        System.out.println(pq.poll() + " " + pq.peek());
        System.out.println(pq.poll());
    }
}
