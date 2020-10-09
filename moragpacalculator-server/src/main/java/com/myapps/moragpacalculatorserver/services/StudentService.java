package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Student;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<List<Student>> getAllStudents();
    //ResponseEntity<Student> studentProfileCreation(StudentCategory studentCategory);
    ResponseEntity<Student> createStudent(String userId, StudentCategory studentCategory);

}
