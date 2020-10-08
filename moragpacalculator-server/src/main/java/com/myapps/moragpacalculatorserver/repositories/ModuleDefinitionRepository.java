package com.myapps.moragpacalculatorserver.repositories;

import com.myapps.moragpacalculatorserver.dataModels.ModuleDefinition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleDefinitionRepository extends MongoRepository<ModuleDefinition, String> {
    ModuleDefinition findByModuleCode(String moduleCode);
}
