package annotation;
/*
* 自定义注解
*
* */

import org.junit.Test;

import java.lang.reflect.Method;

public class annotationDemo2 {
    @Author(name="chenlin")
    public void save() throws NoSuchMethodException {
       /*
       * 利用反射得到注解的信息
       *
       * */
       //得到该类的方法
        Method save = this.getClass().getMethod("save");
        //得到该方法的注解
        Author annotation = save.getAnnotation(Author.class);
        //得到注解里的数据
        String name = annotation.name();
        String date = annotation.date();
        System.out.println(name);
        System.out.println(date);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        new annotationDemo2().save();
    }

}
