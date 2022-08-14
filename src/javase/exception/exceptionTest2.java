package javase.exception;


// 需求：如果产生异常就交给调用处进行处理，而方法继续执行
// 解决方案：try....catch....finally、throw、throws联合使用
public class exceptionTest2 {
    public static void main(String[] args) throws Exception{
        Math m = new Math();
        try {
            System.out.println("除法操作：" + m.div(10,0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Math{
    public int div(int i,int j) throws Exception{  //本方法不处理异常，由调用处进行处理
        System.out.println("------计算开始------");
        int temp = 0;
        try {
            temp = i / j;    //此处有可能出现异常
        }catch (Exception e){
            throw e;      //如果产生异常，则抛给调用处
        }finally {
            System.out.println("------计算结束------"); //继续执行方法的语句
        }
        return temp;         //返回计算结果
    }
}
