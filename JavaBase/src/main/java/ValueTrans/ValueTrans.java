package ValueTrans;

import java.util.Scanner;

/**
 * @ClassName JavaBase.ValueTrans
 * @Author lizhanxu
 * @Date 2019/9/9  17:43
 * @Version V1.0.0
 */
public class ValueTrans {
    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    StringTrans();
                    break;
                case 2:
                    IntTrans();
                    break;
                case 3:
                    ObjectTrans();
                    break;
                case 4:
                    ImmuTrans();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Error! Please input again.");
            }
        }
    }

    /**
     *
     * 在被掉函数中
     */
    private static void StringTrans() {
        System.out.println("String 参数传递");
        String str = "Apple";
        System.out.println("本体："+str);
        strchange(str);//将String对象的引用传递过去，被调函数得到该引用的拷贝，这两个引用均指向同一个String对象
        System.out.println("修改后："+str);
    }

    private static void strchange(String s) {
        s = "Banana";//由于形参s得到的是str的拷贝，所以修改引用s使其指向另一个String对象“Banana”，并不影响实参str，引用str仍然指向String对象“Apple”
        System.out.println("修改值："+s);
    }

    private static void IntTrans() {
        System.out.println("Int 参数传递");
        int a = 1;
        System.out.println("本体：" + a);
        intchange(a);//对于基本数据类型，将值a的拷贝传过去
        System.out.println("修改后："+a);
    }

    private static void intchange(int b) {
        b = 2;
        System.out.println("修改值：" + b);
    }

    private static void ObjectTrans() {
        System.out.println("普通对象参数传递");
        Student stu = new Student("Lee", 18);
        System.out.println("本体："+stu);
        objchange(stu);//对于普通对象的传参，传递的是对象的引用的拷贝
        System.out.println("修改后："+stu);
    }

    /**
     * 拿到对象的引用，形参和实参指向同一个对象，通过这两个引用中的任意一个都能访问该对象进行修改
     */
    private static void objchange(Student student) {
        student.setName("Domino");
        student.setAge(17);
        System.out.println("修改值："+student);
    }

    /**
     * 不可变类无法修改，所以不可变类无法通过任意引用对该对象进行修改
     */
    private static void ImmuTrans() {
        System.out.println("自定义不可变类参数传递");
        Immutable address = new Address("成都市武侯区玉林街道", "400520", 1);
        System.out.println("本体："+address);
        address = immuchange(address);
        System.out.println("通过重新创建实例来修改："+address);

    }

    private static Immutable immuchange(Immutable add) {
        System.out.println("不可变类无法修改！\n"+"形参："+add);
        Immutable address = new Address();
        return address;
    }

}

