package javase.generic;

// Class泛型测试
public class GenericTest5 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cla = Class.forName("java.lang.String");
        System.out.println(cla);

        Class<Integer> clb = Integer.class;
        System.out.println(clb);

        cla = Double.class;
        System.out.println(cla);

        new Entity<>(Long.class).getClassType();
        new Entity<>(Void.class).getClassType();

        // getClass会返回Class<?>
        // cla.getClass();
    }
}

// 定义泛型类
class Entity<T> {
    private Class<T> entityClass;

    public Entity(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void getClassType() {
        System.out.println(entityClass.getName());
    }
}
