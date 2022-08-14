package thread;

import java.util.concurrent.TimeUnit;

public class InterruptWayOne {
    private static volatile boolean stopFlag = false;

    public static void main(String[] args) {

        new Thread(() -> {
            while(true) {
                if(stopFlag) {
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
            stopFlag = true;
        }, "t2").start();
    }
}
