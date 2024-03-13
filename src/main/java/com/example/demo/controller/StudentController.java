package com.example.demo.controller;

import com.example.demo.model.dto.Store;
import com.example.demo.model.dto.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

//restFUL API，綜合範例。使用POST、GET、PUT、DELETE對應Create、Read、Update、Delete操作，用ResponseEntity設定httpCode並回傳數值。
//使用@Validated、@Valid，搭配model中的@NotNull、@NotBlank、@NotEmpty進行快速驗證

@RestController
@Validated
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(path="/store", method = {RequestMethod.GET, RequestMethod.POST})
    public Store product(){
        //http://localhost:8080/test/store
        Store store = new Store();
        List<String> product = new ArrayList<>();
        product.add("蘋果");
        product.add("橘子");

        store.setProductList(product);

        return store;
    }
    @RequestMapping(path = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public Student user(){
        //http://localhost:8080/test/user
        Student student = new Student();
        student.setName("Judy");

        return student;
    }

    @PostMapping("/add")
    public ResponseEntity<Student> create(@RequestBody @Valid Student student) {

        Integer studentId = studentService.insert(student);

        Student newStudent = studentService.getById(studentId);

        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> read(@PathVariable @Min(1) Integer studentId){

        Student student = studentService.getById(studentId);

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<?> update(@PathVariable Integer studentId, @RequestBody Student student){

        student.setId(studentId);
        studentService.update(student);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> delete(@PathVariable Integer studentId){

        studentService.deleteById(studentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
