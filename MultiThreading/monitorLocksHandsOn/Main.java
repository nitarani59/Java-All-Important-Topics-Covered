package MultiThreading.monitorLocksHandsOn;

public class Main {
    public static void main(String[] args) {
        MonitorLockHandsOn obj = new MonitorLockHandsOn();
        MonitorLockHandsOn obj1 = new MonitorLockHandsOn();
        Thread t1 = new Thread(() -> obj.task1());
        Thread t2 = new Thread(() -> obj1.task2());
        Thread t3 = new Thread(() -> obj.task3());
        t1.start();
        t2.start();
        t3.start();
    }
}
