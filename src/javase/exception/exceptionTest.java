package javase.exception;

import javax.naming.InsufficientResourcesException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

// 测试try..catch,throws
public class exceptionTest {
    public static void main(String args[]) {

        // try..catch..捕获异常
        try {
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
        }
        System.out.println("Out of the block");
    }

    // 多重捕获块
    public static int test1(String fileName) {
        int x = 0;
        try {
            FileInputStream file = new FileInputStream(fileName);
            x = (byte) file.read();
        } catch (FileNotFoundException f) { // Not valid!
            f.printStackTrace();
            return -1;
        } catch (IOException i) {
            i.printStackTrace();
            return -1;
        }
        return x;
    }

    // throws关键字
    public void test2() throws RemoteException, InsufficientResourcesException {
        //
        throw new RemoteException();
    }


}
