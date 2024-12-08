package MultiThreading.multipleWays;

public class UsingRunnableInterface implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            System.out.println("Thread is Running " + i);
        }
    }

    public static void main(String[] args) {
        UsingRunnableInterface obj = new UsingRunnableInterface();
        Thread t = new Thread(obj);
        t.start();

        UsingRunnableInterface obj1 = new UsingRunnableInterface();
        Thread t1 = new Thread(obj1);
        t1.start();
    }
}
