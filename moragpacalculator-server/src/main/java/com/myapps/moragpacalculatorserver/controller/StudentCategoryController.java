package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.services.StudentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class StudentCategoryController {

    @Autowired
    private StudentCategoryService studentCategoryService;

    @PostMapping("/student-categories")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<StudentCategory> addNewStudentCategory(@RequestBody StudentCategory studentCategory) {
        return studentCategoryService.addNewStudentCategory(studentCategory);
    }
    @GetMapping("/student-categories")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<StudentCategory>> getAllStudentCategories() {
        return studentCategoryService.getAllStudentCategories();
    }

}
