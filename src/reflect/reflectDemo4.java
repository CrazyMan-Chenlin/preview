package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class reflectDemo4 {
    public static void main(String[] args) {
        try {
            Class student = Class.forName("Bean.Student");
            Constructor constructor = student.getConstructor(null);
                Object obj = constructor.newInstance(null);

            //获取域值
            Field[] declaredFields = student.getDeclaredFields();
            //获取域名与域类型
            for (Field field : declaredFields){
                System.out.println(field.getName());
                System.out.println(field.getType());
            }
            /*
            * 使用反射技术给域值赋值
            *
            * */
            Field name = student.getDeclaredField("name");
            name.setAccessible(true);  //打破封装性
            name.set(obj,"rose");
            Object value = name.get(obj); //得到属性值
            System.out.println(value);
        }  catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch(NoSuchFieldException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
