package generic;

import Bean.Student;

/*
* 泛型接口可以在实现类中确定类型
* 泛型接口可在继承实现类确定类型
* */
public class genericDemo2 {
}
interface IBaseDao<T>{
    void save(T t);
    void update(T t);
}
/*
* 具体dao类
* */
 class EmpDao<Student> implements IBaseDao<Student>{
     @Override
     public void save(Student student) {
     }

     @Override
     public void update(Student student) {
     }
 }
  /*
  通用dao类
  */
  class Base<T> implements IBaseDao<T>{

      @Override
      public void save(T t) {

      }

      @Override
      public void update(T t) {

      }
  }
  /*
  * 具体dao类
  * */
  class StudentDao<Student> extends Base<Student>{
      @Override
      public void save(Student student) {
          super.save(student);
      }

      @Override
      public void update(Student student) {
          super.update(student);
      }
  }

