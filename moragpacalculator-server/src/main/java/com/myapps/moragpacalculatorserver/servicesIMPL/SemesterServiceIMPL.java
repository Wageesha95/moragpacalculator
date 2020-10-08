package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.Semester;
import com.myapps.moragpacalculatorserver.dataModels.SemesterDefinition;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.repositories.SemesterRepository;
import com.myapps.moragpacalculatorserver.repositories.StudentCategoryRepository;
import com.myapps.moragpacalculatorserver.services.CourseService;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SemesterServiceIMPL implements SemesterService {

    @Autowired
    private StudentCategoryRepository studentCategoryRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private ModuleService moduleService;

    public ArrayList<Semester> createSemesters(String userId, StudentCategory studentCategory, ArrayList<SemesterDefinition> semesterDefinitionArrayList) {
        try {
            ArrayList<Semester> allSemestersArrayList = new ArrayList<>();
            for (SemesterDefinition semesterDefinition : semesterDefinitionArrayList) {
                ArrayList<String> moduleCodesArrayList = new ArrayList<>();
                semesterDefinition.getModuleCodes().forEach(moduleCodesArrayList::add);
                ArrayList<Module> semesterModuleArrayList = moduleService.enrollForDefaultModules(userId, studentCategory, moduleCodesArrayList);
                Semester semester = createDefaultSemester(userId, studentCategory, semesterDefinition.getSemesterNo(), semesterModuleArrayList);
                allSemestersArrayList.add(semester);
            }
            return allSemestersArrayList;
        } catch (Exception e) {
            throw e;
        }
    }

    public Semester createDefaultSemester(String userId, StudentCategory studentCategory, String semesterNo, ArrayList<Module> semesterModuleArrayList) {
        try {
            Semester semester = new Semester();
            semester.setUserId(userId);
            semester.setSemesterNo(semesterNo);
            semester.setStudentCategory(studentCategoryRepository.findStudentCategoryByFacultyAndBatchAndCourse(studentCategory.getFaculty(), studentCategory.getBatch(), studentCategory.getCourse()));
            semester.setSemesterModule(semesterModuleArrayList);
            semester.setSemesterGPA(null);
            semester.setCumulativeGPA(null);

            semesterRepository.save(semester);
            return semester;
        } catch (Exception e) {
            throw e;
        }
    }
}

//    ResponseEntity<Semester> updateSemester(String userId,Semester semester){
//        try {
//            Semester _semester= new Semester();
//            moduleRepository.save(_module);
//            return new ResponseEntity<>(_semester, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//        }
//    }


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
