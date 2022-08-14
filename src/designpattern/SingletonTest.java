package designpattern;

public class SingletonTest {
    public static void main(String[] args) {

    }
}


class Singleton1 {
    private Singleton1(){}

    //懒汉式双检锁实现
    private volatile static Singleton1 obj;

    public static Singleton1 getInstance() {
        if(obj == null) {
            synchronized (Singleton1.class) {
                if(obj == null) {
                    obj = new Singleton1();
                }
            }
        }
        return obj;
    }
}

class Singleton2 {
    private Singleton2() {}

    // 懒汉式传统实现
    private static Singleton2 obj;

    public static synchronized Singleton2 getInstance() {
        if(obj == null) {
            obj = new Singleton2();
        }
        return obj;
    }
}


class Singleton3 {
    private Singleton3() {}
    // 饿汉式传统实现
    private static Singleton3 obj = new Singleton3();
    public static Singleton3 getInstance() {
        return obj;
    }


}

class Singleton4 {
    private Singleton4(){}

    // 饿汉式优化实现
    private static class SingletonHolder {
        private static Singleton4 instance = new Singleton4();
    }
    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }
}
