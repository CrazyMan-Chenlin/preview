package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class reflectDemo2 {
@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //得到构造方法
        try {
            Class student = Class.forName("Bean.Student");
            //调用有参的构造方法
            Constructor constructor = student.getConstructor(String.class, int.class);
            Object roy = null;
            roy = constructor.newInstance("roy", 1234);
            System.out.println(roy.getClass().getSimpleName());
            System.out.println(roy);
            //调用无参构造方法
            Constructor constructor1 = student.getConstructor(null);
            Object o = constructor1.newInstance();
            System.out.println(o.getClass().getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
