package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import com.myapps.moragpacalculatorserver.dataModels.Student;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import com.myapps.moragpacalculatorserver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/{userId}/student")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity <Student> createStudent(@PathVariable("userId") String userId, @RequestBody StudentCategory studentCategory) {
        return studentService.createStudent(userId, studentCategory);
    }

    @GetMapping("/students")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Student>> getAllStudents() {
        return studentService.getAllStudents();
    }

}
