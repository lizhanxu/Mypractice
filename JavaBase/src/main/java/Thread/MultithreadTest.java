package Thread;


/**
 * @ClassName MultithreadTest
 * @Author lizhanxu
 * @Date 2019/8/23  15:04
 * @Version V1.0.0
 */
public class MultithreadTest extends Thread {

    private int i;

    private ThreadLocal<String> name = new ThreadLocal<>();

    @Override
    public void run(){
        for (;i<100;i++){
            System.out.println(getName()+"----->"+i);
        }
    }

    public static void main(String[] args) {
        System.out.println("main start");
        for (int i =1;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"----->"+i);
            if (i==20){
                new MultithreadTest().start();
                new MultithreadTest().start();
            }
        }
    }
}
