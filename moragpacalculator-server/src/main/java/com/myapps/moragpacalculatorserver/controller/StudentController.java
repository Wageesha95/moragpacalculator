package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

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
