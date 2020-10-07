package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.CourseDefinition;
import com.myapps.moragpacalculatorserver.services.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CourseController {

    @Autowired
    private CourseDefinitionService courseDefinitionService;

    @PostMapping("/course")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<CourseDefinition> addNewCourseDefinition(@RequestBody CourseDefinition courseDefinition){
        System.out.println();
        return courseDefinitionService.addNewCourseDefinition(courseDefinition);
    }
//    @GetMapping("/modules")
//    //@PreAuthorize("hasRole('USER')")
//    public ResponseEntity<List<Module>> getAllModules() {
//        return moduleService.getAllModules();
//    }
}
