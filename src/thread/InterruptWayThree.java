package thread;

import java.util.concurrent.TimeUnit;

public class InterruptWayThree {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("stop the world");
                    break;
                }
                System.out.println("hello world");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            t1.interrupt();
        }, "t2").start();
    }
}
