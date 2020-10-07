package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class StudentController {

    @Autowired
    private StudentService studentService;

//    @PostMapping("/student")
//    //@PreAuthorize("hasRole('USER')")
//    public ResponseEntity<Module> studentProfileCreation(@RequestBody StudentCategory studentCategory) {
//        return studentService.studentProfileCreation(studentCategory);
//    }
    //update user profile
    //update enrolements
}
