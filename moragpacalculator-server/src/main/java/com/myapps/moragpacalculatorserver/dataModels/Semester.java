package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Semesters")
public class Semester {

    @Id
    private String id;
    private String studentId;
    private StudentCategory studentCategory;
    private String semesterNo;
    private ArrayList<Module> semesterModule;



}
