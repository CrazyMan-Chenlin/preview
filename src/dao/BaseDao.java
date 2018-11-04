package dao;

import Bean.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUitl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {
    private Class targetClass;
    private String tableName;
    /*
    * 需要解决的问题
    * 1.首先得到泛型的具体类型，可以给BeanHandler封装
    * 2.得到表名，表名要与泛型类型名一致
    * */
    public BaseDao(){
           // this 代表当前运行类对象
        System.out.println(this.getClass());
        Class clazz = this.getClass();
        //得到当前运行类的父类（参数化类型） type 可以是数组类型，基本数据类型等
        Type type = clazz.getGenericSuperclass();
        //当type类型强转成我们要的参数化类型（参数化类型: ParameterizedType）
        ParameterizedType type1 = (ParameterizedType) type;
        //得到泛型列表
        Type[] actualTypeArguments = type1.getActualTypeArguments();
        //拿到第一个泛型
        Type actualTypeArgument = actualTypeArguments[0];
        //强转成Class类
        targetClass = (Class) actualTypeArgument;
        tableName =targetClass.getSimpleName().toLowerCase();

    }
    public List<T> queryAll() throws SQLException {
        QueryRunner qr=new QueryRunner(JdbcUitl.getDataSource());
        String sql="select * from "+tableName;
        List<T> query = (List<T>) qr.query(sql, new BeanListHandler(targetClass));
        return query;
    }
   public T  query(int id) throws SQLException {
       QueryRunner qr=new QueryRunner(JdbcUitl.getDataSource());
       String sql="select * from "+tableName+"where id=?";
       T query = (T) qr.query(sql, new BeanHandler(targetClass),new Object[]{id});
       return query;
   }
}
