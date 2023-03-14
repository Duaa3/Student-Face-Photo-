package com.InstituteManagementSystem.InMS.Service;

import com.InstituteManagementSystem.InMS.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StudentService {
    public List<Student> listOfStudent = new CopyOnWriteArrayList<>();
    int currId = 1;
    public List<Student> getAllStudents() {
        return listOfStudent;
    }
        public Student getAStudent(int id) {
          Optional <Student> foundRecord = listOfStudent.stream().filter(
                    (currentStudent) -> {
                        return currentStudent.id == id;
                    }).findFirst();
            return foundRecord.orElse(null);
    }

    public Student creatStudent(Student currStudent){
        currStudent.id = this.currId++;
        listOfStudent.add(currStudent);
        return currStudent;
    }
    public Student uptdateStudent(int id,Student upToDateStudent){
       Student foundStudent = getAStudent(id);
        foundStudent.name = upToDateStudent.name;
        foundStudent.email = upToDateStudent.email;
        return foundStudent;
    }
    public Student deleteStudent(int id){
        Student foundStudent = getAStudent(id);
        listOfStudent.remove(foundStudent);
        return foundStudent;
    }



    }


