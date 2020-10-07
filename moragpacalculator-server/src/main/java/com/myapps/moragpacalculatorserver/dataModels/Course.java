package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;


public class Course {
    @Id
    private String id;
    private String courseName;
    private HashMap<String,Semester> courseContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public HashMap<String, Semester> getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(HashMap<String, Semester> courseContent) {
        this.courseContent = courseContent;
    }
}
