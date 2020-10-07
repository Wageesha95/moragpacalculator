package com.myapps.moragpacalculatorserver.servicesIMPL;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class StudentServiceIMPL{

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


}
