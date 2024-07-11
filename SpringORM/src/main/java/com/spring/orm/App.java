package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        //Student student = context.getBean("student", Student.class);

        Student student = new Student(1,"Rahat","Tangail");
        System.out.println( "Hello, your insertion is completeted");
        int r = studentDao.insert(student);
        System.out.println( "Hello, your insertion is completeted"+r);
    }
}
