package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ModuleService {

    ResponseEntity<ModuleDefinition> addNewModule(ModuleDefinition moduleDefinition);
    ResponseEntity<List<ModuleDefinition>> getAllModules();
}
