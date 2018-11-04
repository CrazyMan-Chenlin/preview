package str_dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import str_Bean.ColumnName;
import str_Bean.TableName;
import util.JdbcUitl;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
* 目标：1.解决表名与javabean名不一致的问题
*       2.解决javabean属性名与表属性名不一致
*
* */
@SuppressWarnings("unchecked")
public class BaseDao<T> {
    private Class targetClass;
    private String tableName;
    public BaseDao(){
        Class clazz = this.getClass();
        Type type = clazz.getGenericSuperclass();
        ParameterizedType type1 = (ParameterizedType) type;
        Type[] actualTypeArguments = type1.getActualTypeArguments();
        Type actualTypeArgument = actualTypeArguments[0];
        targetClass = (Class) actualTypeArgument;
        //必须返回一个特定的注解类才能得到起方法
        TableName tn = (TableName) targetClass.getAnnotation(TableName.class);
        tableName=tn.name();
    }
    public List<T> queryAll() throws SQLException {
        QueryRunner qr=new QueryRunner(JdbcUitl.getDataSource());
        String sql="select * from "+tableName;
        List<T> query = (List<T>) qr.query(sql,new MyBeanHandeler());
        return query;
    }
   public T  query(int id) throws SQLException {
       QueryRunner qr=new QueryRunner(JdbcUitl.getDataSource());
       String sql="select * from "+tableName+" where id=? ";
       T query = (T) qr.query(sql,new MyBeanHandeler(),new Object[]{id});
       return query;
   }

    class MyBeanHandeler implements ResultSetHandler {

        @Override
        @SuppressWarnings("unchecked")
        public Object handle(ResultSet rs) throws SQLException {
           int count =0;//用来判断是是单个查询还是多条件查询
            //构造一个列表来存放对象
            List<T> list = new ArrayList<>();
            //得到表的元数据
            ResultSetMetaData metaData = rs.getMetaData();
            //得到表的column的长度
            int columnCount = metaData.getColumnCount();
            //进行分装,遍历
            T t=null;
            while (rs.next()) {
                count++;
                try {
                    //通过放射的方法，构造一个对象
                    t = (T) targetClass.getDeclaredConstructor().newInstance();
                    //遍历同一行
                    for (int i = 1; i <= columnCount; i++) {
                        //得到第i列的值
                        Object value = rs.getObject(i);
                        //得到列名
                        String columnName = metaData.getColumnName(i).toLowerCase();
                        //得到所有域对象，遍历得其注解上的列名
                        Field[] declaredFields = targetClass.getDeclaredFields();
                        //遍历域对象
                        for (Field field : declaredFields) {
                            //通过放射注解，得到注解
                            ColumnName annotation = field.getAnnotation(ColumnName.class);
                            //得到绑定的列名
                            String name = annotation.name().toLowerCase();
                            //与之前得到的列名作比较，如果相同，即可将其value封装到该对象中
                            if (columnName.equals(name)) {
                                field.setAccessible(true);//设置可以访问
                                field.set(t, value);//设置属性value
                                break;
                            }
                        }
                    }
                    list.add(t);//添加对象
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (count==1){
                return t;
            }else {
                return list;//返回对象
            }
        }
    }
}