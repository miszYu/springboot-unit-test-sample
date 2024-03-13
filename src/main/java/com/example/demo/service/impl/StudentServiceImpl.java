package com.example.demo.service.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.dto.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student insertByName(Student student){
        return studentDao.insertByName(student);
    }

    @Override
    public void insertBatchByNames(List<Student> students){
        studentDao.insertBatchByNames(students);
    }

    @Override
    public void deleteById(Integer id){
        studentDao.deleteById(id);
    }

    @Override
    public List<Student> findAll(){
        return studentDao.findAll();
    }

    @Override
    public Student getById(Integer id){
        return studentDao.findById(id);
    }

    @Override
    public Integer insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

}
