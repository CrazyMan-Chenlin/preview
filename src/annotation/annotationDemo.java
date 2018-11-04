package annotation;

import java.util.ArrayList;
import java.util.List;

public class annotationDemo {
    @Override  //覆盖
    public String toString() {
        return super.toString();
    }
    @SuppressWarnings(value ={"unchecked"} ) //告诉编译器取消未检查警告
    public List save(){
        List<String> list=new ArrayList();
        return list;
    }
    @Deprecated //使方法过期
    public void update(){

    }
    public void update(String name){

    }
    public static void main(String[] args) {
            new annotationDemo().update();
            new annotationDemo().update("aaa");
    }
}
