package thread;

public class ThreadTest {

    public static void main(String[] args) {
        // 测试继承Thread类来创建线程
        MyThread1 t1 = new MyThread1("Thread1");
        t1.start();

        MyThread1 t2 = new MyThread1("Thread2");
        t2.start();

        // 测试实现Runnable来创建线程
        /*thread.MyThread2 r1 = new thread.MyThread2("Thread1");
        r1.start();
        thread.MyThread2 r2 = new thread.MyThread2("Thread2");
        r2.start();*/
    }
}

// 继承Thread类来创建线程，必须重写run，必须调用start执行。
class MyThread1 extends Thread{

    private Thread t;
    private String threadName;

    MyThread1(String name) {
        threadName = name;
        System.out.println("Creating: " + threadName);
    }


    @Override
    public void run() {
        System.out.println("Running: " + threadName);
        try{
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", 执行" + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread: " + threadName + "interrupted");
        }
        System.out.println("Thread: " + threadName + "exiting.");
    }

    public void start() {
        System.out.println("Starting: " + threadName);
        if(t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

// 实现Runnable接口来创建线程，可以在类中实例化一个线程对象
class MyThread2 implements Runnable {
    private Thread t;
    private String threadName;

    MyThread2(String name) {
        threadName = name;
        System.out.println("Creating: " + threadName);
    }


    @Override
    public void run() {
        System.out.println("Running: " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", 执行" + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread: " + threadName + "interrupted");
        }
        System.out.println("Thread: " + threadName + "exiting.");
    }

    public void start() {
        System.out.println("Starting: " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
