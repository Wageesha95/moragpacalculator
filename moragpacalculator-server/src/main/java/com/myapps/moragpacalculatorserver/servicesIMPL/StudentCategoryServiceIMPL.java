package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.repositories.StudentCategoryRepository;
import com.myapps.moragpacalculatorserver.services.StudentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class StudentCategoryServiceIMPL implements StudentCategoryService {

    @Autowired
    private StudentCategoryRepository studentCategoryRepository;

        public ResponseEntity<StudentCategory> addNewStudentCategory(StudentCategory studentCategory){
        try {
            StudentCategory _studentCategory = new StudentCategory(studentCategory.getFaculty(),studentCategory.getDepartment(), studentCategory.getBatch(),studentCategory.getCourse());
            studentCategoryRepository.save(_studentCategory);
            return new ResponseEntity<>(_studentCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<StudentCategory>> getAllStudentCategories() {

        try {
            List<StudentCategory> studentCategories = new ArrayList<StudentCategory>();

//                if (category == null)
            studentCategoryRepository.findAll().forEach(studentCategories::add);
//                else
//                    advertisementRepository.findByCategoryContaining(category).forEach(advertisements::add);

            if (studentCategories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(studentCategories, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
