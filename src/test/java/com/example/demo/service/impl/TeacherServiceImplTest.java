package com.example.demo.service.impl;

import com.example.demo.dao.TeacherRepostory;
import com.example.demo.model.dto.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@AutoConfigureTestDatabase
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2, replace = AutoConfigureTestDatabase.Replace.ANY)
public class TeacherServiceImplTest {

    @Autowired
    private TeacherRepostory teacherRepostory;

    @Test
    void findById() {
        Teacher teacher = teacherRepostory.findById(1).orElse(null);

        assertNotNull(teacher);
        assertEquals("Paggy", teacher.getName());
    }
}