package com.example.demo.service;

import com.example.demo.model.dto.Student;

import java.util.List;

public interface StudentService {

    Student insertByName(Student student);

    void insertBatchByNames(List<Student> students);

    void deleteById(Integer id);

    List<Student> findAll();

    Student getById(Integer id);

    Integer insert(Student student);

    void update(Student student);

}
