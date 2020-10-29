package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.repositories.ModuleDefinitionRepository;
import com.myapps.moragpacalculatorserver.repositories.ModuleRepository;
import com.myapps.moragpacalculatorserver.repositories.StudentCategoryRepository;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Service
public class ModuleServiceIMPL implements ModuleService {

    @Autowired
    private ModuleDefinitionRepository moduleDefinitionRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private StudentCategoryRepository studentCategoryRepository;

    @Autowired
    private SemesterService semesterService;

    public ArrayList<Module> enrollForDefaultModules(String userId, StudentCategory studentCategory,ArrayList<String> moduleCodesArrayList) {

        try {
            ArrayList<Module> semesterModuleArrayList = new ArrayList();
            for (String moduleCode : moduleCodesArrayList) {
                ModuleDefinition moduleDefinition = moduleDefinitionRepository.findByModuleCode(moduleCode);
                if(!moduleDefinition.getElective()){
                    Module _module = new Module();
                    _module.setUserId(userId);
                    _module.setStudentCategory(studentCategoryRepository.findStudentCategoryByFacultyAndBatchAndCourse(studentCategory.getFaculty(),studentCategory.getBatch(),studentCategory.getCourse()));
                    _module.setModuleCode(moduleCode);
                    _module.setModuleName(moduleDefinition.getModuleName());
                    _module.setCredit(moduleDefinition.getModuleCredits());
                    _module.setResult(null);
                    _module.setGpa(moduleDefinition.getGpa());
                    _module.setElective(moduleDefinition.getElective());
                    _module.setEnrollment(true);

                    moduleRepository.save(_module);
                    semesterModuleArrayList.add(_module);
                }
            }
            return semesterModuleArrayList;
        } catch (Exception e) {
            throw  e;
        }
    }

    public ArrayList<Module> updateSemesterModules( ArrayList<Module> semesterModulesArrayList) {
        ArrayList <Module> newSemesterModuleArraylist = new ArrayList<>();
        try{
        for(Module module: semesterModulesArrayList){
            Module _module = module;
            _module.setResult(module.getResult());
            _module.setEnrollment(module.getEnrollment());
            moduleRepository.save(_module);
            newSemesterModuleArraylist.add(_module);
        }
            return newSemesterModuleArraylist;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResponseEntity<Module> updateModule(Module newModuleData) {
        try {
            Optional<Module> existModule = moduleRepository.findById(newModuleData.getId());
            if (existModule.isPresent()) {
                Module _module = existModule.get();

                _module.setEnrollment(newModuleData.getEnrollment());
                moduleRepository.save(_module);
                return new ResponseEntity<>(_module, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    public ResponseEntity<List<Module>> enrollForDefaultModules(String userId, StudentCategory studentCategory) {
//
//        try {
//            ArrayList<Semester> allSemestersArrayList = new ArrayList<>();
//
//
//            ArrayList<Module> allModulesArrayList = new ArrayList();
//            ArrayList<SemesterDefinition> semesterDefinitionArrayList = new ArrayList<>();
//
//            CourseDefinition courseDefinition = courseDefinitionRepository.findCourseDefinitionByCourseName(studentCategory.getCourse());
//
//            courseDefinition.getCourseContentDefinition().forEach(semesterDefinitionArrayList::add);
//            for (SemesterDefinition semesterDefinition : semesterDefinitionArrayList) {
//                ArrayList<Module> semesterModuleArrayList = new ArrayList();
//                ArrayList<String> moduleCodesArrayList = new ArrayList<>();
//                semesterDefinition.getModuleCodes().forEach(moduleCodesArrayList::add);
//                for (String moduleCode : moduleCodesArrayList) {
//                    ModuleDefinition moduleDefinition = moduleDefinitionRepository.findByModuleCode(moduleCode);
//                    if(!moduleDefinition.getElective()){
//                        Module _module = new Module();
//                        _module.setUserId(userId);
//                        _module.setStudentCategory(studentCategoryRepository.findStudentCategoryByFacultyAndBatchAndCourse(studentCategory.getFaculty(),studentCategory.getBatch(),studentCategory.getCourse()));
//                        _module.setModuleCode(moduleCode);
//                        _module.setModuleName(moduleDefinition.getModuleName());
//                        _module.setCredit(moduleDefinition.getModuleCredits());
//                        _module.setResult(null);
//                        _module.setGpa(moduleDefinition.getGpa());
//                        _module.setElective(moduleDefinition.getElective());
//
//                        moduleRepository.save(_module);
//                        semesterModuleArrayList.add(_module);
//                        allModulesArrayList.add(_module);//remove later
//                    }
//                }
//                allSemestersArrayList.add((Semester)semesterService.createDefaultSemester(userId,studentCategory,semesterDefinition.getSemesterNo(), semesterModuleArrayList));
//
//            }
//            return new ResponseEntity<>(allModulesArrayList, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}

