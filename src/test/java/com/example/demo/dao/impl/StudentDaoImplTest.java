package com.example.demo.dao.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.dto.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@AutoConfigureTestDatabase
public class StudentDaoImplTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void findById(){
        Student strudent = studentDao.findById(1);

        assertNotNull(strudent);
        assertEquals("Amy", strudent.getName());

    }

//    @Test
//    void insert() {
//    }
}