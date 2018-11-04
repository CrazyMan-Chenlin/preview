package dao;

import Bean.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentDao extends BaseDao<Student> {
    @Override
    public List<Student> queryAll() throws SQLException {
        return super.queryAll();
    }

    @Override
    public Student query(int id) throws SQLException {
        return super.query(id);
    }

}
