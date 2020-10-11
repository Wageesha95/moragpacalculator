package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface ModuleService {


    ArrayList<Module> enrollForDefaultModules(String userId, StudentCategory studentCategory,ArrayList<String> moduleCodesArrayList);
    ArrayList<Module> updateSemesterModules( ArrayList<Module> semesterModulesArrayList);
}
