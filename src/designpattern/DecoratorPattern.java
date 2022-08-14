package designpattern;

public class DecoratorPattern {
    public static void main(String[] args) {
        new RobotDecorator(new FirstRobot()).doMorething();
    }
}

interface Robot {
    void doSomething();
}

class FirstRobot implements Robot {
    @Override
    public void doSomething() {
        System.out.println("对话");
        System.out.println("唱歌");
    }
}

class RobotDecorator implements Robot {
    private Robot robot;

    public RobotDecorator(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMorething() {
        robot.doSomething();
        System.out.println("扫地");
    }
}
