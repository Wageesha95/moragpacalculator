package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Document("Courses")
public class Course {
    @Id
    private String id;
    private String userId;
    private String courseName;
    @DBRef
    private HashMap<String,Semester> courseContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
