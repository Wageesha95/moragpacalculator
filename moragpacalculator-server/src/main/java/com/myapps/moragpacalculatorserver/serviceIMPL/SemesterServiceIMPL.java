package com.myapps.moragpacalculatorserver.serviceIMPL;

import com.myapps.moragpacalculatorserver.repositories.CourseDefinitionRepository;
import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterServiceIMPL implements SemesterService {

    @Autowired
    private CourseDefinitionRepository courseRepository;


//    public ResponseEntity<List<Module>> createSemester(StudentCategory studentCategory){
//        try{
//          List<Module> semesterModules = new ArrayList<Module>();
//            if (courseRepository.findByCourse(studentCategory.getCourse()).isPresent()) {
//                courseRepository.findByCourse(studentCategory.getCourse()).get().getSem1().forEach(semesterModules::add);
//                return new ResponseEntity<>(semesterModules, HttpStatus.CREATED);
//            }else{
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//    } catch (Exception e) {
//        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//    }
//
//    }
}
