package com.spring.jdbc.dao;

import com.spring.jdbc.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
       int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    @Override
    public int change(Student student) {
        String query = "update student set name=?,city=? where id=?";
        int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return 0;
    }

    @Override
    public int delete(int studentId) {
        String query = "delete student where id = ?";
        int r = this.jdbcTemplate.update(query,studentId);
        return r;
    }

    @Override
    public Student getStudent(int studentId) {
        //select single student data object
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
       List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
