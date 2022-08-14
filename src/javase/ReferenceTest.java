package javase;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {
    public static void main(String[] args) {
        // 声明软引用
        SoftReference<String> ruan = new SoftReference<>(new String("penguin"));
        System.out.println(ruan.get());

        // 声明弱引用
        WeakReference<String> ruo = new WeakReference<>(new String("penguin"));
        System.out.println(ruo.get());

        // JVM垃圾回收
        System.gc();

        System.out.println(ruan.get());
        System.out.println(ruo.get());
    }
}
