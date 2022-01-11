package com.tyy.spring.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
@IdClass(StudentEntity.StudentEntityKey.class)
public class StudentEntity implements Serializable {

    @Id
    private String id;
    @Id
    private String name;

    private int age;
    private String addr;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class  StudentEntityKey implements Serializable{
        private String id;
        private String name;
    }


}
