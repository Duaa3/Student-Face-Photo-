package com.InstituteManagementSystem.InMS.Controller;

import com.InstituteManagementSystem.InMS.Model.Student;
import com.InstituteManagementSystem.InMS.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/students")// Mapping this controller to the "/api/students" path
public class StudentController {
    // Injecting the StudentService dependency into the controller
    @Autowired
    private StudentService studentService;
    // GET request to retrieve all students
    @GetMapping
    public List<Student> getStudent(){
        return studentService.getAllStudents(); // Call the StudentService method to get all students
    }

    // GET request to retrieve a specific student by ID
    @GetMapping(path = "/{id}")
    public Student getStudents(@PathVariable(name = "id") int id){
        return studentService.getAStudent(id);

    }
    // POST request to create new student
    @PostMapping
    public  Student creatStudent(@RequestBody Student currStudent){
        studentService.creatStudent(currStudent);
        return currStudent;
    }
    // PUT request to update an existing student by ID
    @PutMapping(path = "/{id}")
    public Student updateStudent(@PathVariable(name = "id") int id, @RequestBody Student currStudent){
       studentService.uptdateStudent(id, currStudent);
        return currStudent;
    }
    // DELETE request to delete a specific student by ID
    @DeleteMapping (path = "/{id}")
    public Student deletStudent(@PathVariable(name = "id") int id){
        return  studentService.deleteStudent(id);
    }
}
