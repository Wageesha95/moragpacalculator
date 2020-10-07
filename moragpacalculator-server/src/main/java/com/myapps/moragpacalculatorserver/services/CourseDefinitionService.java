package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.CourseDefinition;
import org.springframework.http.ResponseEntity;

public interface CourseDefinitionService {
    ResponseEntity<CourseDefinition> addNewCourseDefinition(CourseDefinition courseDefinition);
}
