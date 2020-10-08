package com.myapps.moragpacalculatorserver.servicesIMPL;


import com.myapps.moragpacalculatorserver.dataModels.Course;
import com.myapps.moragpacalculatorserver.dataModels.Student;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.dataModels.UserProfile;
import com.myapps.moragpacalculatorserver.repositories.StudentCategoryRepository;
import com.myapps.moragpacalculatorserver.repositories.StudentRepository;
import com.myapps.moragpacalculatorserver.services.CourseService;
import com.myapps.moragpacalculatorserver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCategoryRepository studentCategoryRepository;

    public ResponseEntity<Student> createStudent(String userId, StudentCategory studentCategory){
        Student student = new Student();
        try{
            Course course = courseService.createCourse(userId,studentCategory);

            //student.setUserProfile(userProfile);
            student.setStudentCategory(studentCategoryRepository.findStudentCategoryByFacultyAndBatchAndCourse(studentCategory.getFaculty(), studentCategory.getBatch(), studentCategory.getCourse()));
            student.setCourse(course);
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }
    }

//    @Autowired
//    private StudentRepository studentRepository;
//
//    public ResponseEntity<List<Student>> getAllStudents(){
//
//        try {
//            List<Student> Students = new ArrayList<Student>();
//
////            if (category == null)
//                studentRepository.findAll().forEach(Students::add);
////            else
////                StudentRepository.findByCategoryContaining(category).forEach(Students::add);
//
//            if (Students.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(Students, HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//
//    };
//
//    public ResponseEntity<Student> studentProfileCreation(StudentCategory studentCategory) {
//        try{
//            if(studentCategory.getCourse().equals("IT")){
//                Enrollement _enrollement = new Enrollement();
//                _enrollement.setStudentCategory(studentCategory);
//                _enrollement.setEnrolled_semesters();
//            }
//        }
//        try {
//            Student _student = new Student();
//
//            _student.setName(student.getName());
//            _student.setEmail(student.getEmail());
//            studentRepository.save(_student);
//            return new ResponseEntity<>(_student, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//        }
//    }
