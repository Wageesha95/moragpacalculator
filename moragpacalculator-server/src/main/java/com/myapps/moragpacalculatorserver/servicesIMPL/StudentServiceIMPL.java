package com.myapps.moragpacalculatorserver.servicesIMPL;


import com.myapps.moragpacalculatorserver.dataModels.Course;
import com.myapps.moragpacalculatorserver.dataModels.Student;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.dataModels.UserProfile;
import com.myapps.moragpacalculatorserver.repositories.StudentCategoryRepository;
import com.myapps.moragpacalculatorserver.repositories.StudentRepository;
import com.myapps.moragpacalculatorserver.services.CourseService;
import com.myapps.moragpacalculatorserver.services.StudentService;
import com.myapps.moragpacalculatorserver.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCategoryRepository studentCategoryRepository;

    @Autowired
    private UserProfileService userProfileService;

    public ResponseEntity<Student> createStudent(String profileId, StudentCategory studentCategory) {
        Student student = new Student();
        try {
            Course course = courseService.createCourse(profileId, studentCategory);

            student.setUserProfile(userProfileService.getUserProfile(profileId));
            student.setStudentCategory(studentCategoryRepository.findStudentCategoryByFacultyAndBatchAndCourse(studentCategory.getFaculty(), studentCategory.getBatch(), studentCategory.getCourse()));
            student.setCourse(course);
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<List<Student>> getAllStudents() {

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


    }

    public ResponseEntity <Student> getStudentByProfileId(String profileId) {

        try {
            UserProfile userProfile = userProfileService.getUserProfile(profileId);
            Optional<Student> student =studentRepository.findByUserProfile(userProfile);
            if (!student.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
             Student _student = student.get();
            return new ResponseEntity<>(_student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}