package com.InstituteManagementSystem.InMS.Controller;

import com.InstituteManagementSystem.InMS.Model.Student;
import com.InstituteManagementSystem.InMS.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getAllStudents();
    }
    @GetMapping(path = "/{id}")
    public Student getStudents(@PathVariable(name = "id") int id){
        return studentService.getAStudent(id);

    }
    @PostMapping
    public  Student creatStudent(@RequestBody Student currStudent){
        studentService.creatStudent(currStudent);
        return currStudent;
    }
    @PutMapping(path = "/{id}")
    public Student updateStudent(@PathVariable(name = "id") int id, @RequestBody Student currStudent){
       studentService.uptdateStudent(id, currStudent);
        return currStudent;
    }
    @DeleteMapping (path = "/{id}")
    public Student deletStudent(@PathVariable(name = "id") int id){
        return  studentService.deleteStudent(id);
    }
}
