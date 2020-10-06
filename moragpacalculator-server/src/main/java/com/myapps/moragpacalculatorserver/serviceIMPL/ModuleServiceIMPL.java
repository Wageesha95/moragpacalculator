package com.myapps.moragpacalculatorserver.serviceIMPL;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.repositories.ModuleRepository;
import com.myapps.moragpacalculatorserver.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ModuleServiceIMPL implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public ResponseEntity<Module> addNewModule(Module module) {
        try {
            Module _module = new Module(module.getModule_code(), module.getModule_name(), module.getModule_credits(), module.getGpa(), module.getElective());
            moduleRepository.save(_module);
            return new ResponseEntity<>(_module, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}