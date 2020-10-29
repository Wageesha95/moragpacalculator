package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import com.myapps.moragpacalculatorserver.services.ModuleDefinitionService;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ModuleController {


    @Autowired
    private ModuleDefinitionService moduleDefinitionService;

    @Autowired
    private ModuleService moduleService;

    @PostMapping("/modules")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<ModuleDefinition> addNewModule(@RequestBody ModuleDefinition moduleDefinition) {
        return moduleDefinitionService.addNewModule(moduleDefinition);
    }
    @GetMapping("/modules")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ModuleDefinition>> getAllModules() {
        return moduleDefinitionService.getAllModules();
    }

    @PutMapping("/module")
    public ResponseEntity<Module> updateModule(@RequestBody Module newModuleData){
        return moduleService.updateModule(newModuleData);
    }
    //add
    //update
    //delete
    //find
}
