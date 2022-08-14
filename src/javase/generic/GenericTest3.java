package javase.generic;

import java.util.LinkedList;
import java.util.List;

// 测试泛型接口、方法

public class GenericTest3 {
    public static void main(String[] args) {
        // 查看集合的泛型源码
        List<Integer> list = new LinkedList<>();

    }

    // 测试泛型方法
    public <T1, T2> void fun(T1 t1, T2 t2) {
        System.out.println(t1);
        System.out.println(t2);
    }
}

class cat implements animal {

    // 默认使用Object类型
    @Override
    public Object getValue(Object o) {
        return null;
    }
}

// 子类不设置泛型，父类接口的泛型需要明确类型
class pig implements animal<String> {

    @Override
    public String getValue(String s) {
        return s + "呼呼";
    }
}



// 子类和接口均使用泛型
class dog<T> implements animal<T> {

    @Override
    public T getValue(T t) {
        return t;
    }
}
