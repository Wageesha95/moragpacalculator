package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import com.myapps.moragpacalculatorserver.repositories.ModuleDefinitionRepository;
import com.myapps.moragpacalculatorserver.services.ModuleDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleDefinitionServiceIMPL implements ModuleDefinitionService {

    @Autowired
    private ModuleDefinitionRepository moduleDefinitionRepository;

    public ResponseEntity<ModuleDefinition> addNewModule(ModuleDefinition moduleDefinition) {
        try {
            ModuleDefinition _moduleDefinition = new ModuleDefinition(moduleDefinition.getModuleCode(), moduleDefinition.getModuleName(), moduleDefinition.getModuleCredits(), moduleDefinition.getGpa(), moduleDefinition.getElective());
            moduleDefinitionRepository.save(_moduleDefinition);
            return new ResponseEntity<>(_moduleDefinition, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<ModuleDefinition>> getAllModules() {
        try {
            List<ModuleDefinition> moduleDefinitions = new ArrayList<ModuleDefinition>();
            moduleDefinitionRepository.findAll().forEach(moduleDefinitions::add);
            if (moduleDefinitions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(moduleDefinitions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
