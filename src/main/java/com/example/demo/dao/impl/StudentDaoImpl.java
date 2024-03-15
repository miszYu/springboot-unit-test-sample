package com.example.demo.dao.impl;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.dto.Student;
import com.example.demo.model.mapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private NamedParameterJdbcTemplate myjdbcJdbcTemplate;

    @Override
    public Student insertByName(Student student){
        String sql = "INSERT INTO STUDENT (name) VALUES (:name)";

        String name = student.getName();

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        myjdbcJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        Integer id = keyHolder.getKey().intValue();

        student.setId(id);

        return student;
    }

    @Override
    public void insertBatchByNames(List<Student> students){
        String sql = "INSERT INTO STUDENT (name) VALUES (:name)";

        List<MapSqlParameterSource> parameterSourceList = new ArrayList<>();
        MapSqlParameterSource parameterSource = null;

        for (Student std : students){
            parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("name", std.getName());

            parameterSourceList.add(parameterSource);
        }
        MapSqlParameterSource[] parameterSources = parameterSourceList.toArray( new MapSqlParameterSource[parameterSourceList.size()]);
        myjdbcJdbcTemplate.batchUpdate(sql, parameterSources);
    }

    @Override
    public void deleteById(Integer id){
        String sql = "DELETE FROM STUDENT WHERE ID = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        myjdbcJdbcTemplate.update(sql, map);

    }
    @Override
    public List<Student> findAll(){
        String sql = "SELECT id, name FROM STUDENT";

        Map<String,Object> map = new HashMap<>();

        List<Student> list =  myjdbcJdbcTemplate.query(sql, map, new StudentRowMapper());

        return list;
    }

    @Override
    public Student findById(Integer id){
        String sql = "SELECT id, name, score, graduate, create_date FROM STUDENT where id = :id";

        Map<String,Object> map = new HashMap<>();
        map.put("id", id);

        List<Student> list =  myjdbcJdbcTemplate.query(sql, map, new StudentRowMapper());

        return list.size() > 0 ? list.get(0) : new Student(null, "查無資料");
    }

    @Override
    public Integer insert(Student student) {
        String sql = "INSERT INTO student(name, score, graduate, create_date) VALUES (:name, :score, :graduate, :createDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("name", student.getName());
        map.put("score", student.getScore());
        map.put("graduate", student.isGraduate());
        map.put("createDate", new Date());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        myjdbcJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 id 為: " + id);

        return id;
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE student SET name = :name, score = :score, graduate = :graduate WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", student.getId());
        map.put("name", student.getName());
        map.put("score", student.getScore());
        map.put("graduate", student.isGraduate());

        myjdbcJdbcTemplate.update(sql, map);
    }
}
