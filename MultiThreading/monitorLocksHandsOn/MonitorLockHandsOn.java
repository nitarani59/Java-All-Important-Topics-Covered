package MultiThreading.monitorLocksHandsOn;

public class MonitorLockHandsOn {

    public synchronized void task1() {
        System.out.println("Task 1 executed");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Execution completed of task 1");

    }

    public synchronized  void task2() {
        System.out.println("Task 2 executed");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized  void task3() {
        System.out.println("Task 3 executed");
    }
}
