package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import com.myapps.moragpacalculatorserver.services.StudentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private  ModuleService moduleService;

    @Autowired
    private StudentCategoryService studentCategoryService;

    @PostMapping("/modules")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<Module> addNewModule(@RequestBody Module module) {
        return moduleService.addNewModule(module);
    }
    @GetMapping("/modules")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Module>> getAllModules() {
        return moduleService.getAllModules();
    }
    @PostMapping("/student-categories")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<StudentCategory> addNewStudentCategory(@RequestBody StudentCategory studentCategory) {
        return studentCategoryService.addNewStudentCategory(studentCategory);
    }

}
