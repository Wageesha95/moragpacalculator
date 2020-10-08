package com.myapps.moragpacalculatorserver.repositories;

import com.myapps.moragpacalculatorserver.dataModels.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course,String> {
}
