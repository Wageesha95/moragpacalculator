package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Document(collection = "Courses")
public class CourseDefinition {
    private String courseName;
    private HashMap<String,ArrayList<String>> courseContentDefinition;

    public CourseDefinition() {
    }

    public CourseDefinition(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public HashMap<String, ArrayList<String>> getCourseContentDefinition() {
        return courseContentDefinition;
    }

    public void setCourseContentDefinition(HashMap<String, ArrayList<String>> courseContentDefinition) {
        this.courseContentDefinition = courseContentDefinition;
    }
}
