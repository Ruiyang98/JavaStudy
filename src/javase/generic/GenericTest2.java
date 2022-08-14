package javase.generic;

// 测试类的泛型
public class GenericTest2 {
    public static void main(String[] args) {
    Node<String> node1 = new Node<>("666");
    String value1 = node1.getValue();

    Node<Integer> node2 = new Node<>(66);
    Integer value2 = node2.getValue();

    System.out.println(value1);
    System.out.println(value2);
    }
}

class Node <T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node(T value) {
        this.value = value;
    }
}
