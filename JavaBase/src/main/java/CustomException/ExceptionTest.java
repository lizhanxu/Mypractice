package CustomException;

/**
 * @ClassName ExceptionTest
 * @Author lizhanxu
 * @Date 2019/9/12  11:43
 * @Version V1.0.0
 */
public class ExceptionTest {

    /**
     * main方法throws将异常抛给JVM
     * JVN对异常的处理方法是，打印异常跟踪栈信息，并终止程序运行
     */

    public static void main(String[] args) {
        //该方法内已经处理了异常，不会再向上级抛出
        handleCommonException();

        System.out.println("after handle CommonException");

        //Checked异常必须显示处理,必须在方法声明中throws抛给上级或者try...catch捕获处理
        try {
            throwCommonException_1();
        } catch (CommonException e) {
            e.printStackTrace();
            System.out.println("handled CommonException");
        }

        try {
            //该方法声明throws Checked异常，但方法体中并没有异常实例throw
            //因为该方法声明throws Checked异常，所以必须要显示处理，否则**编译不通过**
            //这种情况并没有进入catch块
            throwCommonException_2();
        } catch (CommonException e) {
            System.out.println("catched CommonException");//并没有进入catch块
            e.printStackTrace();
        }

        //Runtime可以不做显示处理，但是会隐式的逐级往上抛，如果中途没有try...catch捕获处理，则最终会抛到JVM,由JVM处理
        throwCommonRuntimeException();
    }

    //try...catch捕获，并在catch块中处理了异常
    private static void handleCommonException() {
        try {
            throw new CommonException("handle CommonException");//抛出一个异常实例到这个try块
        } catch (CommonException e) {
            //打印异常追踪栈信息
            e.printStackTrace();
            System.out.println("handled CommonException");
        }
    }

    //将该Checked异常抛给该方法的调用者
    private static void throwCommonException_1() throws CommonException{
        throw new CommonException("throws CommonException");
    }

    //该方法声明throws Checked异常，但方法体中并没有异常实例throw
    private static void throwCommonException_2() throws CommonException{

    }

    //将该Runtime异常抛给上级
    private static void throwCommonRuntimeException() throws CommonRuntimeException {
        throw new CommonRuntimeException("throws ");//抛出一个异常实例到这个方法
    }
}
