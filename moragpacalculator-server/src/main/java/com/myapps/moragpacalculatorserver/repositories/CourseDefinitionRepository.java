package com.myapps.moragpacalculatorserver.repositories;

import com.myapps.moragpacalculatorserver.dataModels.Course;
import com.myapps.moragpacalculatorserver.dataModels.CourseDefinition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseDefinitionRepository extends MongoRepository<CourseDefinition,String> {

}
