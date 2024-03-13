package com.example.demo.dao;

import com.example.demo.model.dto.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//CrudRepository<Class, primary key type>
//@Repository//可不用寫，jpa內部實作會引入@Repository
public interface TeacherRepostory extends CrudRepository<Teacher, Integer> {

    List<Teacher> findByName(String name);

    //nativeQuery，使用哪種語法，true = 一般SQL、false = JPQL
    @Query(value = "SELECT ID, NAME, GENDER, STAFFLV FROM TEACHER WHERE GENDER=?1 AND STAFFLV=?2", nativeQuery = true)
    List<Teacher> findByGender_Stafflv(String gender, String stafflv);

    @Modifying
    @Query(value = "UPDATE TEACHER SET STAFFLV=?2 WHERE ID=?1", nativeQuery = true)
    void updateStafflvById(Integer id, String stafflv);
}
