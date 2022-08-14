package javase.generic;

import java.util.ArrayList;
import java.util.List;

// 测试限定通配符
public class GenericTest4 {

    public static void main(String[] args) {
        List<Animal> list1 = new ArrayList<>();
        List<Dog> list2 = new ArrayList<>();
        List<Cat> list3 = new ArrayList<>();

        // 都可以，因为都是Animal或它的子类
        print1(list1);
        print1(list2);
        print1(list3);

        // Dog或其父类都可以，其他不行
        print2(list1);
        print2(list2);
        //print2(list3);
    }


    // 上边界限定
    static void print1(List<? extends Animal> list) {
        for(Animal animal : list) {
            System.out.println(animal);
        }
    }

    // 下边界限定
    static void print2(List<? super Dog> list) {
        // dosomething
    }
}

class Animal {
    //dosomething
}
class Dog extends Animal {
    //dosomething
}
class Cat extends Animal {
    //dosomething
}


