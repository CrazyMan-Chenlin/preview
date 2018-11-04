package reflect;

public class reflectDemo1 {
    public static void main(String[] args) {
        //得到类对象,该方式依赖性低
        try {
            Class Student = Class.forName("Bean.Student");
            //得到类名
            System.out.println(Student.getName());
            //得到简单名
            System.out.println(Student.getSimpleName());
            //得到父类
            Class superclass = Student.getSuperclass();
            System.out.println(superclass.getName());
            //得到接口
            Class[] interfaces = Student.getInterfaces();
            for(Class cla: interfaces){
                System.out.println(cla.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
