package generic;
/*
* 泛型方法与泛型类
*  泛型方法必须写在泛型类与泛型接口中
* */
public class genericDemo1<K,T> {
    public static void main(String[] args) {
        genericDemo1<String, Integer> gen = new genericDemo1<>();
    }
    /*

    * 泛型方法的类型在调用方法时确认
    * 泛型类的类型在调用时确认
    * */
    public T save(K k,T t){
        return t;
    }
    public void update(T t,K k){

    }
}
