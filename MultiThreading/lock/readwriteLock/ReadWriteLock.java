package MultiThreading.lock.readwriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();
    private int value;

    // Method to read the value
    public int readValue() {
        readLock.lock();  // Acquire read lock
        System.out.println("Read lock applied. " + Thread.currentThread().getName());
        try {
            return value;
        } finally {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Read Lok released by " + Thread.currentThread().getName());
            readLock.unlock();  // Release read lock
        }
    }

    // Method to write the value
    public void writeValue(int value) {
        writeLock.lock();  // Acquire write lock
        System.out.println("Write lock applied.");

        try {
            this.value = value;
        } finally {
            writeLock.unlock();  // Release write lock
            System.out.println("Write lock released.");

        }
    }

    public static void main(String[] args) {
        ReadWriteLock example = new ReadWriteLock();

        // Thread to read value
        Thread reader = new Thread(() -> {
            System.out.println("Read Value: thread 0 " + example.readValue());
        });
        Thread reader1 = new Thread(() -> {
            System.out.println("Read Value: thread 1 " + example.readValue());
        });

        // Thread to write value
        Thread writer = new Thread(() -> {
            example.writeValue(42);
            System.out.println("Wrote Value: 42");
        });

        reader.start();
        reader1.start();
        writer.start();
    }
}


