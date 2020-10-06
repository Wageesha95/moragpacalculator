package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Semesters")
public class Semester {

    @Id
    private String id;
    private StudentCategory studentCategory;
    private Integer semester_number;
    private List<Module> semester_modules;



}
