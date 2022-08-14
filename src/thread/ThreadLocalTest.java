package thread;

public class ThreadLocalTest {
    private static ThreadLocal<String> localvar = new ThreadLocal<>();

    static void print(String str) {
        // 打印当前线程中，本地内存中，本地变量的值
        System.out.println(str + " :" + localvar.get());
        // 清除本地内存中的本地变量
        localvar.remove();
    }

    public static void main(String[] args) throws InterruptedException{
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.localvar.set("local_A");
                print("A");
                System.out.println("after remove : " + localvar.get());
            }
        }, "A").start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalTest.localvar.set("local_B");
                print("B");
                System.out.println("after remove : " + localvar.get());
            }
        }, "B").start();
    }


}
