package MultiThreading.lock.synchronizedLock;

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producer = new Thread(sharedResource::addItem);
        producer.start();

        SharedResource sharedResource1 = new SharedResource();
        Thread producer1 = new Thread(sharedResource1::addItem);
        producer1.start();
    }
}
