package JavaBase.ValueTrans;

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

    private static void StringTrans() {
        System.out.println("String 参数传递");
        String str = "Apple";
        System.out.println("本体："+str);
        strchange(str);
        System.out.println("修改后："+str);
    }

    private static void strchange(String s) {
        s = "Banana";
        System.out.println("修改值："+s);
    }

    private static void IntTrans() {
        System.out.println("Int 参数传递");
        int a = 1;
        System.out.println("本体：" + a);
        intchange(a);
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
        objchange(stu);
        System.out.println("修改后："+stu);
    }

    private static void objchange(Student student) {
        student.setName("Domino");
        student.setAge(17);
        System.out.println("修改值："+student);
    }

    private static void ImmuTrans() {
        System.out.println("自定义不可变类参数传递");
        Immutable address = new Address("成都市武侯区玉林街道", "400520", 1);
        System.out.println("本体："+address);
        System.out.println("通过重新创建实例来修改："+immuchange(address));
    }

    private static Immutable immuchange(Immutable add) {
        System.out.println("不可变类无法修改！\n"+"形参："+add);
        Immutable address = new Address();
        return address;
    }

}

