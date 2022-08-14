package javase.serializable;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args) {
        writeObj();
        readObj();
    }

    public static void writeObj() {
        User user = new User("1001", "Joe");

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\workspace\\test\\src\\javase\\serializable\\OutPut.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readObj() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\workspace\\test\\src\\javase\\serializable\\OutPut.txt"));
            try {
                Object object = objectInputStream.readObject();
                User user = (User) object;
                System.out.println(user);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
