package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Enrolements")
public class Enrollement {

    @Id
    private String id;
    private StudentCategory studentCategory;
    private List<Semester> enrolled_semesters;


}
