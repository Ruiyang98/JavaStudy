package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class InterruptWayTwo {
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {

        new Thread(() -> {
            while(true) {
                if(atomicBoolean.get()) {
                    System.out.println("stop the world");
                    break;
                }
                System.out.println("hello world");
            }
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            atomicBoolean.set(true);
        }, "t2").start();
    }
}
