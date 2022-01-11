package com.tyy.spring.controller;

import com.tyy.spring.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController {

    StudentService studentService;

    @RequestMapping("/stu")
    public void save(){
        studentService.save();
    }

}
