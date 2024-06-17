package MultiThreading.producerConsumerProblem;

import java.util.Stack;

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                sharedResource.addItem();
            }
        }
        );
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                sharedResource.consumeItem();
            }
        });
        producer.start();
        consumer.start();
    }
}
