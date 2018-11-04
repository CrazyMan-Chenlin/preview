package test.dao; 

import Bean.Student;
import dao.StudentDao;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* StudentDao Tester. 

*/ 
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
@Test
public void testQueryAll() throws Exception { 
//TODO: Test goes here...
    StudentDao studentDao = new StudentDao();
    List<Student> students = studentDao.queryAll();
    for(Student stu:students){
        System.out.println(stu);
    }
} 

/** 
* 
* Method: query(int id) 
* 
*/ 
@Test
public void testQuery() throws Exception {


} 


} 
