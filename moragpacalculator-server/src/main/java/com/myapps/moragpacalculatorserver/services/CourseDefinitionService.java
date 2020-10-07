package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Course;
import com.myapps.moragpacalculatorserver.dataModels.CourseDefinition;
import com.myapps.moragpacalculatorserver.dataModels.Module;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Map;

public interface CourseDefinitionService {
    ResponseEntity<CourseDefinition> addNewCourseDefinition(CourseDefinition courseDefinition);
}
