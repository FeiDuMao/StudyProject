package com.tyy.spring;

import com.tyy.spring.dao.StudentEntity;
import com.tyy.spring.dao.StudentRepository;
import com.tyy.spring.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
        System.out.println("Hello");
        List<StudentEntity> all = studentRepository.findAll();
        all.forEach(System.out::println);
    }

}
