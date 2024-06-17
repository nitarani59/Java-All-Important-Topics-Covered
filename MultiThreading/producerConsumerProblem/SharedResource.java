package MultiThreading.producerConsumerProblem;

import java.util.Random;
import java.util.Stack;

public class SharedResource {
    Stack<Integer> st = new Stack<>();

    public synchronized void addItem() {
        while (st.size() == 4) {
            try {
                System.out.println("Waiting to be empty");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        st.add(new Random().nextInt(10));
        System.out.println("Producer Thread: available - " + st.peek());
        notify();

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
