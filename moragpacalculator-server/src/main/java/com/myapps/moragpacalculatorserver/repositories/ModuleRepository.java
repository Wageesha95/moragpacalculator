package com.myapps.moragpacalculatorserver.repositories;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends MongoRepository<Module, String> {
}