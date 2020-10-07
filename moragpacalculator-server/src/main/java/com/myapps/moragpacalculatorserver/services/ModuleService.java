package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ModuleService {

    ResponseEntity<Module> addNewModule(Module module);
    ResponseEntity<List<Module>> getAllModules();
}
