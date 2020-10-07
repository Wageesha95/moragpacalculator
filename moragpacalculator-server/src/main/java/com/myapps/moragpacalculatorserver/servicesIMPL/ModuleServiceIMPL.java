package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import com.myapps.moragpacalculatorserver.repositories.ModuleRepository;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ModuleServiceIMPL implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public ResponseEntity<ModuleDefinition> addNewModule(ModuleDefinition moduleDefinition) {
        try {
            ModuleDefinition _moduleDefinition = new ModuleDefinition(moduleDefinition.getModule_code(), moduleDefinition.getModule_name(), moduleDefinition.getModule_credits(), moduleDefinition.getGpa(), moduleDefinition.getElective());
            moduleRepository.save(_moduleDefinition);
            return new ResponseEntity<>(_moduleDefinition, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<List<ModuleDefinition>> getAllModules() {
        try {
            List<ModuleDefinition> moduleDefinitions = new ArrayList<ModuleDefinition>();
                moduleRepository.findAll().forEach(moduleDefinitions::add);
            if (moduleDefinitions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(moduleDefinitions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
