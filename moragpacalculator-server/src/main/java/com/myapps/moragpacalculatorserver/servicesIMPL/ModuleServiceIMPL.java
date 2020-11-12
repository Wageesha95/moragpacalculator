package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import com.myapps.moragpacalculatorserver.dataModels.Semester;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.repositories.*;
import com.myapps.moragpacalculatorserver.services.ModuleDefinitionService;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private ModuleDefinitionService moduleDefinitionService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private SemesterRepository semesterRepository;

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

    public ArrayList<Module> updateSemesterModules(ArrayList<Module> semesterModulesArrayList) {
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
                _module.setResult(newModuleData.getResult());
                _module.setEnrollment(newModuleData.getEnrollment());
                moduleRepository.save(_module);
                return new ResponseEntity<>(_module, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public ResponseEntity<ArrayList<Module>> getUnenrolledElectiveModuleList(String courseName, String profileId) {
        try {
            ArrayList<ModuleDefinition> allElectiveModuleDefinitionArrayList=moduleDefinitionService.getElectiveModules(courseName).getBody();
            ArrayList<Module> allEnrolledElectiveModuleArrayList=moduleRepository.findAllByUserIdAndElectiveAndEnrollment(profileId,true,true);
            ArrayList<Module> allUnenrolledElectiveModuleArrayList = new ArrayList<>();
            StudentCategory studentCategory = studentRepository.findByUserProfile(userProfileRepository.findById(profileId).get()).get().getStudentCategory();

            for(ModuleDefinition moduleDefinition : allElectiveModuleDefinitionArrayList){
                if(allEnrolledElectiveModuleArrayList.isEmpty()){
                    Module _module = new Module();
                    _module.setUserId(profileId);
                    _module.setStudentCategory(studentCategory);
                    _module.setModuleCode(moduleDefinition.getModuleCode());
                    _module.setModuleName(moduleDefinition.getModuleName());
                    _module.setCredit(moduleDefinition.getModuleCredits());
                    _module.setResult(null);
                    _module.setGpa(moduleDefinition.getGpa());
                    _module.setElective(moduleDefinition.getElective());
                    _module.setEnrollment(false);

                    allUnenrolledElectiveModuleArrayList.add(_module);
                }else{
                    for(Module module :allEnrolledElectiveModuleArrayList){

                        if(!(moduleDefinition.getModuleCode().equals(module.getModuleCode()))){

                            Module _module = new Module();
                            _module.setUserId(profileId);
                            _module.setStudentCategory(studentCategory);
                            _module.setModuleCode(moduleDefinition.getModuleCode());
                            _module.setModuleName(moduleDefinition.getModuleName());
                            _module.setCredit(moduleDefinition.getModuleCredits());
                            _module.setResult(null);
                            _module.setGpa(moduleDefinition.getGpa());
                            _module.setElective(moduleDefinition.getElective());
                            _module.setEnrollment(false);

                            allUnenrolledElectiveModuleArrayList.add(_module);
                        }
                    }
                }
            }
            return new ResponseEntity<>(allUnenrolledElectiveModuleArrayList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteRemovedElectiveModule(String moduleId, String semesterId) {
        try {
            Semester newSemester = semesterRepository.findById(semesterId).get();
            newSemester.getSemesterModule().remove(moduleRepository.findById(moduleId));
            semesterService.updateSemester(newSemester);
            moduleRepository.delete(moduleRepository.findById(moduleId).get());
            //--Don't change the order of above two steps--

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @Override
//    public  ResponseEntity<HttpStatus> deleteUnenrolledModules(ArrayList<Module> existSemesterModules,ArrayList<Module> semesterModulesArrayList,String semesterId) {
//            ArrayList<Module> unenrolledElectiveModules = (ArrayList<Module>) existSemesterModules.clone();
//            try{
//                if(!(existSemesterModules.isEmpty())){
//                    for (Module existModule : existSemesterModules){
//                        for (Module semesterModule : semesterModulesArrayList){
//                            if(existModule.getModuleCode().equals(semesterModule.getModuleCode())){
//                                unenrolledElectiveModules.remove(unenrolledElectiveModules.indexOf(existModule));
//                            }
//                        }
//                        //semesterModulesArrayList.stream().filter(m-> m.getModuleCode()== existModule.getModuleCode()).collect(Collectors.toList()).forEach(unenrolledElectiveModules::add );
//                    }
//                }
//                for(Module module:unenrolledElectiveModules){
//                    Semester newSemester = semesterRepository.findById(semesterId).get();
//                    newSemester.getSemesterModule().remove(moduleRepository.findById(module.getId()));
//                    semesterService.updateSemester(newSemester);
//                    moduleRepository.delete(moduleRepository.findById(module.getId()).get());
//                    //--Don't change the order of above two steps--
//                }
//
//
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}

