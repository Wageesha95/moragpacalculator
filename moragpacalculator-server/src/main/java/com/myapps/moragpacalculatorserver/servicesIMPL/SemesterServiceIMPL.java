package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.*;
import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.repositories.SemesterRepository;
import com.myapps.moragpacalculatorserver.repositories.StudentCategoryRepository;
import com.myapps.moragpacalculatorserver.services.CourseService;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                Boolean trainingSemester=semesterDefinition.getTraining();
                semesterDefinition.getModuleCodes().forEach(moduleCodesArrayList::add);
                ArrayList<Module> semesterModuleArrayList = moduleService.enrollForDefaultModules(userId, studentCategory, moduleCodesArrayList);
                Semester semester = createDefaultSemester(userId, studentCategory, semesterDefinition.getSemesterNo(), semesterModuleArrayList,trainingSemester);
                allSemestersArrayList.add(semester);
            }
            return allSemestersArrayList;
        } catch (Exception e) {
            throw e;
        }
    }

    public Semester createDefaultSemester(String userId, StudentCategory studentCategory, String semesterNo, ArrayList<Module> semesterModuleArrayList,Boolean trainingSemester) {
        try {
            Semester semester = new Semester();
            semester.setUserId(userId);
            semester.setSemesterNo(semesterNo);
            semester.setStudentCategory(studentCategoryRepository.findStudentCategoryByFacultyAndBatchAndCourse(studentCategory.getFaculty(), studentCategory.getBatch(), studentCategory.getCourse()));
            semester.setSemesterModule(semesterModuleArrayList);
            semester.setSemesterGPA(null);
            semester.setCumulativeGPA(null);
            semester.setTraining(trainingSemester);

            semesterRepository.save(semester);
            return semester;
        } catch (Exception e) {
            throw e;
        }
    }

    public ResponseEntity<List<Semester>> getAllSemesters(){
        try {
            List<Semester> semesters = new ArrayList<Semester>();
            semesterRepository.findAll().forEach(semesters::add);
            if (semesters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(semesters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Semester> updateSemester(Semester semester) {
        Optional<Semester> semesterExist = semesterRepository.findById(semester.getId());
        try {
            if (semesterExist.isPresent()) {
                Semester _semester = semesterExist.get();
                //moduleService.deleteUnenrolledModules(_semester.getSemesterModule(),semester.getSemesterModule(),semester.getId());
                _semester.setSemesterModule(moduleService.updateSemesterModules(semester.getSemesterModule()));
                _semester.setSemesterGPA(semester.getSemesterGPA());
                _semester.setCumulativeGPA(semester.getCumulativeGPA());

                semesterRepository.save(_semester);
                return new ResponseEntity<>(_semester, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
