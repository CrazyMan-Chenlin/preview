package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
//元注解
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE}) //指定在哪个地方使用 类型，域，方法，参数，构造方法，本地变量，模块等！
@Retention(RetentionPolicy.RUNTIME)//指定在什么时候起作用，源码/字节码/运行时
public @interface Author {
    String name();
    String date() default "2018-11-06";//默认值

}
