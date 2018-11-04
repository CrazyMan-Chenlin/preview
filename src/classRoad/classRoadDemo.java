package classRoad;

public class classRoadDemo {
    public static void main(String[] args) {
        //得到类加载器
        /*
        jdk3个类加载器
        * 1. bootstrap
        * 2. platform
        * 3. app
        *
        * 类加载过程
        * 1. 一个类A是由某一个类加载，如果类A中使用到了类B，类B也是由类A的加载器加载
        * 2.  发起者类加载器去加载类的时候，先委托其父类加载，如果还有父类加载其，则继续委托上去，直接
        *     没有最顶层的类加载器就需要真正地去加载指定类，如果在其类目录中找不到这个类，继续往下找找到发起者类加载器为止！！
        *    委托机制的好处
        *      可以让代码加载更加安全和高效！保证核心类的字节码只有一份在内存
        * */
        System.out.println(classRoadDemo.class.getClassLoader().getName());
        System.out.println(java.util.Date.class.getClassLoader());
        //查看某个类的树状加载器结构
        ClassLoader classLoader = classRoadDemo.class.getClassLoader();
        while(classLoader!=null){
            System.out.println(classLoader.getName());
            classLoader=classLoader.getParent();
        }
    }
}
