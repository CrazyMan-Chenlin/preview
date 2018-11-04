package test.str_dao; 

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import str_Bean.Student;
import str_dao.StudentDao;

import java.util.List;

public class StudentDaoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: queryAll() 
* 
*/
StudentDao studentDao=new StudentDao();
@Test
public void testQueryAll() throws Exception {
    List<Student> students = studentDao.queryAll();
    for (Student student:students){
        System.out.println(student);
    }
} 

/** 
* 
* Method: query(int id) 
* 
*/ 
@Test
public void testQuery() throws Exception {
    Student query = studentDao.query(1);
    System.out.println(query);
} 

/** 
* 
* Method: handle(ResultSet rs) 
* 
*/ 
@Test
public void testHandle() throws Exception { 
//TODO: Test goes here... 
} 


} 
