package MultiThreading.lock.synchronizedLock;

import java.util.Random;
import java.util.Stack;

public class SharedResource {
    Stack<Integer> st = new Stack<>();

    public synchronized void addItem() {

        st.add(new Random().nextInt(10));
        System.out.println("Producer Thread: available - " + st.peek());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Waiting time finished");
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
