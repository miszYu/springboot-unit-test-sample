//package com.example.demo.controller;
//
//import com.example.demo.model.dto.Teacher;
//import com.example.demo.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
////練習使用spring-jpa
//@Validated
//@RestController
//@RequestMapping("/jpa")
//public class TeacherController {
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @PostMapping("/add")
//    public String create(@RequestBody @Valid Teacher teacher){
//        Teacher result = teacherService.insert(teacher);
//
//        return "新增Teacher成功，id = " + result.getId() + ", name = " + result.getName();
//    }
//
//    @GetMapping("/query/{id}")
//    public Teacher query(@PathVariable @Valid Integer id){
//        Teacher result = teacherService.findById(id);
//
//        if(result != null){
//            return result;
//        }else {
//            return new Teacher(null, "查無資料");
//        }
//
//    }
//
//    @GetMapping("/queryByName/{name}")
//    public List<Teacher> queryByName(@PathVariable @Valid String name){
//        List<Teacher> results = teacherService.findByName(name);
//
//        if(results.size() == 0){
//            results.add(new Teacher(null, "查無資料"));
//        }
//
//        return results;
//    }
//
//
//    @GetMapping("/queryByGender_Stafflv")
//    public List<Teacher> queryByGender_Stafflv(@RequestParam(required = true) @Valid String gender,  @RequestParam(required = true) @Valid String stafflv){
//        List<Teacher> results = teacherService.findByGender_Stafflv(gender, stafflv);
//
//        if(results.size() == 0){
//            results.add(new Teacher(null, "查無資料"));
//        }
//
//        return results;
//    }
//
//    @PutMapping("/updateStafflvById")
//    public String updateStafflvById(@RequestBody @Valid Teacher teacher){
//        teacherService.updateStafflvById(teacher);
//
//        return "修改成功";
//    }
//
//
//}
