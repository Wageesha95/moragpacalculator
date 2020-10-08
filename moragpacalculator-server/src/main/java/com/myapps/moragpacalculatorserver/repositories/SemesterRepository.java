package com.myapps.moragpacalculatorserver.repositories;

import com.myapps.moragpacalculatorserver.dataModels.Semester;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SemesterRepository extends MongoRepository<Semester,String> {
}
