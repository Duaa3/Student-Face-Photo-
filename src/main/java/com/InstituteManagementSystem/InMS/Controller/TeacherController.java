package com.InstituteManagementSystem.InMS.Controller;

import com.InstituteManagementSystem.InMS.Model.Teacher;
import com.InstituteManagementSystem.InMS.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeacher(){
        return teacherService.getAllTeacher();
    }
    @GetMapping(path = "/{id}")
    public Teacher getTeacher(@PathVariable(name = "id") int id){
        return teacherService.getATeacher(id);

    }
    @PostMapping
    public  Teacher creatTeacher(@RequestBody Teacher currTeacher){
        teacherService.creatTeacher(currTeacher);
        return currTeacher;
    }
    @PutMapping(path = "/{id}")
    public Teacher updateTeacher(@PathVariable(name = "id") int id, @RequestBody Teacher currTeacher){
        teacherService.uptdateTeacher(id, currTeacher);
        return currTeacher;
    }
    @DeleteMapping (path = "/{id}")
    public Teacher deletTeacher(@PathVariable(name = "id") int id){
        return  teacherService.deleteTeacher(id);
    }
}
