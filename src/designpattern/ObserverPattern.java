package designpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        Debit zhangsan = new Zhangsan();

        zhangsan.borrow(new Wangwu());
        zhangsan.borrow(new Lisi());

        // 状态改变时，通知观察者
        zhangsan.notifyCredits();
    }
}

// 借款方
interface Debit {
    void borrow(Credit credit);
    void notifyCredits();
}

// 债主
interface Credit {
    void takeMoney();
}

// 具体目标
class Zhangsan implements Debit {
    // 维护一个借款人列表
    private List<Credit> allCredits = new ArrayList<>();
    // 有没有钱的状态，1表示有钱
    private Integer state = 0;

    @Override
    public void borrow(Credit credit) {
        allCredits.add(credit);
    }

    @Override
    public void notifyCredits() {
        allCredits.forEach(credit -> credit.takeMoney());
    }
}

class Wangwu implements Credit{
    public Wangwu() {

    }

    @Override
    public void takeMoney() {
        System.out.println("拿到钱了");
    }
}

class Lisi implements Credit{

    public Lisi() {

    }

    @Override
    public void takeMoney() {
        System.out.println("拿到钱了");
    }
}
