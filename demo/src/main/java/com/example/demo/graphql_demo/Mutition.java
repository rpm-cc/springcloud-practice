package com.example.demo.graphql_demo;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.beans.StudentInput;
import org.springframework.stereotype.Component;

/**
 * the class implements GraphQLMutationResolver ，the graphql-spring-boot-starter
 * will find method in this class mapping mutation witch defined in schema.graphqls
 */
@Component
public class Mutition implements GraphQLMutationResolver {

    public int updateStudent(StudentInput student){

        System.out.printf("Student="+student.toString());
        return 1;
    }
}
