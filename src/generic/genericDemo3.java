package generic;

import java.util.ArrayList;
import java.util.List;

/*
* 泛型关键字 ？ super extend
* */
public class genericDemo3 {
    public static void main(String[] args) throws ClassNotFoundException {
     /*
     * ? 让某个类保持泛型特征
     * 如果一个类加上泛型，则只能接受数据，不能被编译
     * */
        Class<?> student = Class.forName("Bean.Student");
        List<?> list=new ArrayList<>();
         /*
         * 测试extend
         * */
         List<Object> obj=new ArrayList<>();
         List<Integer> integers=new ArrayList<>();
        /*  报错
         new genericDemo3().add(obj);*/
        new genericDemo3().add(integers);//成功
        /*
        * 测试super关键字
        * */
       /* new genericDemo3().add2(integers); //报错*/
       new genericDemo3().add2(obj);//成功编译
    }
    /*
    * extend 关键字
    * */
     public void add(List<? extends Number> list){
     }
     /*
     * super 关键字
     * */
     public void add2(List<? super Number> list){

     }
}
