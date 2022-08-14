package javase.generic;

// 向上转型测试：可以将任何类向上转型成Object进行操作，然后再向下转型。
public class GenericTest {
        public static void main(String[] args) {
            Integer a=10;
            node node1=new node(a);
            Integer va1=(Integer) node1.getValue();
            System.out.println(va1);

            node node2=new node("hello");
            String va2=(String) node2.getValue();
            System.out.println(va2);
        }
}

class node
{
    private Object value;
    public  node(Object value)
    {
        this.value=value;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}
