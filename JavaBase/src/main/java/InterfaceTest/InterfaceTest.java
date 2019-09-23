package InterfaceTest;


/**
 * Object是所有对象的父类
 *
 * 语法上，接口是不能继承任何类（包括Object类）的，但在字节码文件中，接口的父索引都有Object，所以接口和Object存在一定的关系
 *
 * 接口中可以声明Object中的方法，但该接口的实现类中对这些方法可以不显式重写，此时默认实现在Object类中
 *
 * 我认为，接口中可以声明Object中的方法是为了  提醒（而非强制）  开发人员在该接口的实现类中应该重写这些方法
 *
 * @ClassName InterfaceTest
 * @Author lizhanxu
 * @Date 2019/9/23  9:56
 * @Version V1.0.0
 */
public interface InterfaceTest {

    int compare(int a, int b);

    public abstract boolean equals(Object obj);//接口中的方法都默认添加了public abstract关键字

    String toString();

    default void sayHello() {
        System.out.println("Hello");
    }
}
