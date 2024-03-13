package com.example.demo.model.dto;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teacher")
public class Teacher {

    public Teacher(){};

    public Teacher(Integer id, String name){
        this.id = id;
        this.name = name;
    };

    @Id//primary key，需增加@Id的Annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)//AUTO_INCREMENT(自動增長)，需增加@GeneratedValue的Annotation
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Size(min = 1, max = 1)
    @Column(name = "stafflv")
    String stafflv;

    @Size(min = 1,max = 1)
    @Column(name = "gender")
    String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStafflv() {
        return stafflv;
    }

    public void setStafflv(String stafflv) {
        this.stafflv = stafflv;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
