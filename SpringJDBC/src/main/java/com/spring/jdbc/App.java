package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println("My program started...");

        // Correct the path to the classpath-relative location
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        // Get JdbcTemplate bean from context
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        StudentDao studentDao=context.getBean("studentDao", StudentDao.class);

        Student student= new Student();
        student.setId(5);
        student.setName("foysal");
        student.setCity("shokhipur");
        int result=studentDao.insert(student);

        // Print the result
        System.out.println("Number of records inserted: " + result);

        /*int r =studentDao.change(student);

        System.out.println("result changed: " + r);

        int delete= studentDao.delete(1);
        System.out.println("result changed: " +delete);

        Student obj = studentDao.getStudent(12);
        System.out.println(obj);

         */

       List<Student> students = studentDao.getAllStudent();

        for (Student s:students
             ) {
            System.out.println(s);
        }

    }
    }
