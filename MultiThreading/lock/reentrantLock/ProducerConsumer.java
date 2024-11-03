package lock.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SharedResource sharedResource = new SharedResource(lock);
        Thread producer = new Thread(sharedResource::addItem);
        producer.start();

        SharedResource sharedResource1 = new SharedResource(lock);
        Thread producer1 = new Thread(sharedResource1::addItem);
        producer1.start();
    }
}
