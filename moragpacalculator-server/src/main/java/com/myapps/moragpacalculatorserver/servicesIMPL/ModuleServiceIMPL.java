package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.*;
import com.myapps.moragpacalculatorserver.repositories.CourseDefinitionRepository;
import com.myapps.moragpacalculatorserver.repositories.ModuleDefinitionRepository;
import com.myapps.moragpacalculatorserver.repositories.ModuleRepository;
import com.myapps.moragpacalculatorserver.repositories.StudentCategoryRepository;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Service
public class ModuleServiceIMPL implements ModuleService {

    @Autowired
    private CourseDefinitionRepository courseDefinitionRepository;

    @Autowired
    private ModuleDefinitionRepository moduleDefinitionRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private StudentCategoryRepository studentCategoryRepository;

    public ResponseEntity<List<Module>> enrollForDefaultModules(String userId, StudentCategory studentCategory) {

        try {
            List<Module> moduleArrayList = new ArrayList();
            ArrayList<SemesterDefinition> semesterDefinitionArrayList = new ArrayList<>();

            CourseDefinition courseDefinition = courseDefinitionRepository.findCourseDefinitionByCourseName(studentCategory.getCourse());

            courseDefinition.getCourseContentDefinition().forEach(semesterDefinitionArrayList::add);
            for (SemesterDefinition semesterDefinition : semesterDefinitionArrayList) {
                ArrayList<String> moduleCodesArrayList = new ArrayList<>();
                semesterDefinition.getModuleCodes().forEach(moduleCodesArrayList::add);
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

                        moduleRepository.save(_module);
                        moduleArrayList.add(_module);
                    }
                }
            }
            return new ResponseEntity<>(moduleArrayList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

