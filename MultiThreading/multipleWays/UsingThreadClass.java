package MultiThreading.multipleWays;

public class UsingThreadClass extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread is running " + i);
        }
    }

    public static void main(String[] args) {
        UsingThreadClass  t = new UsingThreadClass();
        t.start();
        // When we call start() on thread again, it throws IllegalThreadStateException
        // t.start();

        UsingThreadClass t2 = new UsingThreadClass();
        t2.start();

        UsingThreadClass t3 = new UsingThreadClass();
        t3.start();

        UsingThreadClass t4 = new UsingThreadClass();
        t4.start();
    }
}
