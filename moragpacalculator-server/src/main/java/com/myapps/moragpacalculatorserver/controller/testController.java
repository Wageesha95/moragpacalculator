package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.Student;
import com.myapps.moragpacalculatorserver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private StudentService studentService;

    @GetMapping("hello")
    public ModelAndView welcome(Principal principal) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
        mav.addObject("name", principal.getName());
        return mav;
    }

    @RequestMapping(value = "/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @PostMapping("/signup") // Map ONLY POST Requests
    public ResponseEntity<Student> createStudent(@RequestBody Student Student) {
        return studentService.signUpStudent(Student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return studentService.getAllStudents();
    }
}
