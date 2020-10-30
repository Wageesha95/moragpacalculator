package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

public interface ModuleService {


    ArrayList<Module> enrollForDefaultModules(String userId, StudentCategory studentCategory,ArrayList<String> moduleCodesArrayList);
    ArrayList<Module> updateSemesterModules( ArrayList<Module> semesterModulesArrayList);
    ResponseEntity<Module> updateModule(Module newModuleData);
    ResponseEntity<ArrayList<Module>> getUnenrolledElectiveModuleList(String courseName,String profileId);
}
