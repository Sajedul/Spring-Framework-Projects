package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;
    @Transactional
    public int insert(Student student){
       Integer id =(Integer) this.hibernateTemplate.save(student);
        return id;
    }

    //get single data object
    public Student getStudent(int studentId){
       Student student = this.hibernateTemplate.get(Student.class,studentId);
       return student;
    }

    //get all data
    public List<Student> getAllStudent(){
        List<Student> students =this.hibernateTemplate.loadAll(Student.class);
        return students;
    }
    //delete Student
    public void deleteStudent(int studentId){
       Student student= this.hibernateTemplate.get(Student.class,studentId);
        this.hibernateTemplate.delete(student);
    }
    //update Student
    @Transactional
    public void updateStudent(Student student){

        this.hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {

        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
