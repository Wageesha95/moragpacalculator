package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Course_Definitions")
public class CourseDefinition {
    private String courseName;
    private ArrayList<SemesterDefinition> courseContentDefinition;

//    public CourseDefinition(CourseDefinition courseDefinition) {
//        this.courseName = courseDefinition.getCourseName();
//        this.courseContentDefinition = courseDefinition.getCourseContentDefinition();
//    }

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

    public ArrayList<SemesterDefinition> getCourseContentDefinition() {
        return courseContentDefinition;
    }

    public void setCourseContentDefinition(ArrayList<SemesterDefinition> courseContentDefinition) {
        this.courseContentDefinition = courseContentDefinition;
    }
}
