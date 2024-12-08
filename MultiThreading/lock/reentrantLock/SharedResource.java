package MultiThreading.lock.reentrantLock;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    Stack<Integer> st = new Stack<>();

    ReentrantLock lock;
    public SharedResource(ReentrantLock lock) {
        this.lock = lock;
    }
    public synchronized void addItem() {
        lock.lock();
        System.out.println("Applied Lock");
        st.add(new Random().nextInt(10));
        System.out.println("Producer Thread: available - " + st.peek());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Waiting time finished");
        lock.unlock();
        System.out.println("Lock Released");
    }

    public synchronized void consumeItem() {
        while (st.isEmpty()) {
            try {
                System.out.println("Waiting to be consumed");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Consumer Thread: consumed - " + st.pop());
//        System.out.print(st.pop());
        notify();
    }
}
