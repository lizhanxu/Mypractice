package JavaReflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectServiceImpl
 * @Author lizhanxu
 * @Date 2019/8/20  14:22
 * @Version V1.0.0
 */
public class ReflectServiceImpl {

    private String name;

    public void sayHello(){
        System.err.println("Hello World");
    }

    public void sayHello(String name){
        System.err.println("Hello World" + name);
    }

    public ReflectServiceImpl(){}

    public ReflectServiceImpl(String name){
        this.name = name;
    }

    /**
     * 通过反射得到实例
     * @return 实例
     */
    public static ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)Class.
                    forName("JavaReflect.ReflectServiceImpl").
                    newInstance();//调用无参构造器
        }catch (ClassNotFoundException|InstantiationException|IllegalAccessException e){
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 通过反射调用有参的构造器生成实例
     * @param str
     * @return
     */
    public static ReflectServiceImpl getInstance(String str) {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)Class.
                    forName("JavaReflect.ReflectServiceImpl").getConstructor(String.class).
                    newInstance(str);
        }catch (ClassNotFoundException |InstantiationException
                |IllegalAccessException |NoSuchMethodException
                |SecurityException| InvocationTargetException e){
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 通过反射获取成员方法并调用
     * 如果调用的是非静态方法，所以第一个参数要指定一个实例；如果调用的是一个静态方法则将第一个参数设置为null
     * @return
     */
    public static Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
//        target.sayHello("   直接使用");
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello",String.class);
            returnObj = method.invoke(target,"   张三");//因为调用的是非静态方法，所以第一个参数要指定一个实例；如果调用的是一个静态方法则将第一个参数设置为null
        }catch (IllegalAccessException |NoSuchMethodException
                |SecurityException| InvocationTargetException e){
            e.printStackTrace();
        }
        return returnObj;
    }
}
