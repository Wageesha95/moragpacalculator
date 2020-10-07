package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.CourseDefinition;
import com.myapps.moragpacalculatorserver.repositories.CourseDefinitionRepository;
import com.myapps.moragpacalculatorserver.services.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseDefinitionServiceIMPL implements CourseDefinitionService {

    @Autowired
    private CourseDefinitionRepository courseDirectoryRepository;

    public ResponseEntity<CourseDefinition> addNewCourseDefinition(CourseDefinition courseDefinition) {
        try {
            courseDirectoryRepository.save(courseDefinition);
        return new ResponseEntity<>(courseDefinition, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }

    }
}
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            CourseDefinition _courseDefinition = objectMapper.readValue(courseDefinition.toString(),CourseDefinition.class);
//            for (Map.Entry<String,ArrayList<String>> set : courseDefinition.getCourseContentDefinition().entrySet()) {
//                for(String moduleCode:set.getValue()){
//                System.out.println(set.getKey());
//
//
//                    System.out.println(moduleCode);
//                }
//            }


//        try {
//            for (Map.Entry<String,ArrayList<String>> set : courseDefinition.getCourseContentDefinition().entrySet()) {
//                System.out.println(set.getKey());
//
//                for(String moduleCode:set.getValue()){
//                    System.out.println(moduleCode);
//                }
//            }
//            for (String moduleCode : courseDefinition.getCourseContentDefinition().get("sem1")){
//
//                System.out.println(moduleCode);
//            }


