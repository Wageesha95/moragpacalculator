package com.myapps.moragpacalculatorserver.serviceIMPL;


import com.myapps.moragpacalculatorserver.dataModels.Student;
import com.myapps.moragpacalculatorserver.repositories.StudentRepository;
import com.myapps.moragpacalculatorserver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<List<Student>> getAllStudents(){

        try {
            List<Student> Students = new ArrayList<Student>();

//            if (category == null)
                studentRepository.findAll().forEach(Students::add);
//            else
//                StudentRepository.findByCategoryContaining(category).forEach(Students::add);

            if (Students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(Students, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    };

    public ResponseEntity<Student> signUpStudent(Student student) {
        try {
            Student _student = new Student();
            _student.setName(student.getName());
            _student.setEmail(student.getEmail());
            studentRepository.save(_student);
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }


}
