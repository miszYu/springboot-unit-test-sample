package com.example.demo.model.dto;

import javax.validation.constraints.NotBlank;
import java.util.Date;

//使用@NotNull、@NotBlank、@NotEmpty，搭配@Validated、@Valid進行快速驗證

public class Student {
    private Integer id;

    @NotBlank
    private String name;

    private Double score;
    private boolean graduate;
    private Date createDate;

    public Student(){};
    public Student(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Student(String name, Double score, Boolean graduate){
        this.name = name;
        this.score = score;
        this.graduate = graduate;
        this.createDate = new Date();
    }

    public void print(){
        System.out.println("id = " + id);
        System.out.println("name = " + name );
    }

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public boolean isGraduate() {
        return graduate;
    }

    public void setGraduate(boolean graduate) {
        this.graduate = graduate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
