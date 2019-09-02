package ThreadTest;


/**
 * @ClassName FirstThread
 * @Author lizhanxu
 * @Date 2019/8/23  15:04
 * @Version V1.0.0
 */
public class FirstThread extends Thread {

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
        for (int i =1;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"----->"+i);
            if (i==20){
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }
}
