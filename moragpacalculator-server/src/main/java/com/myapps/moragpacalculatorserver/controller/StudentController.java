package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.*;
import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.services.ModuleDefinitionService;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import com.myapps.moragpacalculatorserver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModuleDefinitionService moduleDefinitionService;

    @PostMapping("/{userId}/student")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity <Student> createStudent(@PathVariable("userId") String userId, @RequestBody StudentCategory studentCategory) {
        return studentService.createStudent(userId, studentCategory);
    }

    @GetMapping("/elective-modules")
    public ResponseEntity<ArrayList<ModuleDefinition>> getElectiveModules(@RequestParam(name = "course") String courseName){
        return moduleDefinitionService.getElectiveModules(courseName);
    }

    @GetMapping("/students")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Student>> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/student")
    public ResponseEntity <Student> getStudentByProfileId(@RequestParam(name = "profileId") String profileId){
        return studentService.getStudentByProfileId(profileId);
    }


}
