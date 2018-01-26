package com.example.demo.graphql_demo;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.beans.Student;
import org.springframework.stereotype.Component;

/**
 * the class implements GraphQLQueryResolver ，the graphql-spring-boot-starter
 * will find method in this class mapping mutation witch defined in schema.graphqls
 */
@Component
public class Query implements GraphQLQueryResolver {

    public Student findStudent() {
        Student student = new Student();
        student.setName("任丕明");
        student.setAge(33);
        student.setSex("男");
        return student;
    }

    public Student findStudentById(int student_id) {
        System.out.printf("student_id=" + student_id);
        Student student = new Student();
        student.setName("任丕明");
        student.setAge(33);
        student.setSex("男");
        return student;
    }
}
