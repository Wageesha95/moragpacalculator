package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentCategoryService {

    ResponseEntity<StudentCategory> addNewStudentCategory(StudentCategory studentCategory);
}
