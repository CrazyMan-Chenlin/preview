package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectDemo3 {
    public static void main(String[] args) {
        try {
            Class student = Class.forName("Bean.Student");
            Constructor con = student.getConstructor(null);
            Object obj = con.newInstance(null);
            /*
           * 参数1 方法名称
           * 参数2 形式参数列表
           * getDeclaredMethod()  得到所有的方法（公共与私有）
           * getMethod()          得到公共的方法
           * */
            Method setName = student.getMethod("setName", String.class);
            Method getName = student.getMethod("getName", null);
            //调用方法
            /*
            * 参数1 调用方法所需的对象
            * 参数2 调用参数列表
            * */
            setName.invoke(obj, "roy");
            System.out.println(obj);

            Object result = getName.invoke(obj, null);
            System.out.println(result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
