package com.nice.login.service;

import com.nice.login.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Resource
    StudentService studentService;
    @Test
    public void getStudentTest(){
        Student student = studentService.getStudentById(1);
        System.out.println(student);

    }
}
