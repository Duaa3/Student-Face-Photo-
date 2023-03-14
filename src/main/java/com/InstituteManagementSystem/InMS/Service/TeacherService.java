package com.InstituteManagementSystem.InMS.Service;

import com.InstituteManagementSystem.InMS.Model.Student;
import com.InstituteManagementSystem.InMS.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TeacherService {
    public List<Teacher> listOfTeacher = new CopyOnWriteArrayList<>();
    int currId = 1;
    public List<Teacher> getAllTeacher() {
        return listOfTeacher;
    }
    public Teacher getATeacher(int id) {
        Optional<Teacher> foundRecord = listOfTeacher.stream().filter(
                (currentTeacher) -> {
                    return currentTeacher.id == id;
                }).findFirst();
        return foundRecord.orElse(null);
    }

    public Teacher creatTeacher(Teacher currTeacher){
        currTeacher.id = this.currId++;
        listOfTeacher.add(currTeacher);
        return currTeacher;
    }
    public Teacher uptdateTeacher(int id,Teacher upToDateTeacher){
        Teacher foundTeacher = getATeacher(id);
        foundTeacher.name = upToDateTeacher.name;
        foundTeacher.email = upToDateTeacher.email;
        return foundTeacher;
    }
    public Teacher deleteTeacher(int id){
        Teacher foundStudent = getATeacher(id);
        listOfTeacher.remove(foundStudent);
        return foundStudent;
    }

}


