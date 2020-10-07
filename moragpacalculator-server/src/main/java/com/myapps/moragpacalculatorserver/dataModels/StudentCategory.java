package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student_Categories")
public class StudentCategory {

    @Id
    private String id;
    private String faculty;
    private String department;
    private String batch;
    private String course;

    public StudentCategory(String faculty, String department, String batch, String course) {
        this.faculty = faculty;
        this.department = department;
        this.batch = batch;
        this.course = course;
    }

//    public StudentCategory(String faculty, String batch, String course) {
//        this.faculty = faculty;
//        this.batch = batch;
//        this.course = course;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
