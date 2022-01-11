package com.tyy.spring.service;

import com.tyy.spring.dao.StudentEntity;
import com.tyy.spring.dao.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository;



    public void save(){
        StudentEntity studentEntity=buildInfo();
        StudentEntity save = studentRepository.save(studentEntity);
        System.out.println(save);

        List<StudentEntity> all = studentRepository.findAll();
        all.forEach(System.out::println);

    }

    private StudentEntity buildInfo(){
        return new StudentEntity("333","tyy",11, "BBB");
    }


}
