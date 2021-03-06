package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "Semesters")
public class Semester {

    @Id
    private String id;
    private String userId;
    @DBRef
    private StudentCategory studentCategory;
    private String semesterNo;
    @DBRef
    private ArrayList<Module> semesterModule;

    private Float semesterGPA;
    private Float cumulativeGPA;

    private Boolean training;

    public Semester() {
    }

    public Semester(String id, String userId, StudentCategory studentCategory, String semesterNo, ArrayList<Module> semesterModule, Float semesterGPA, Float cumulativeGPA, Boolean training) {
        this.id = id;
        this.userId = userId;
        this.studentCategory = studentCategory;
        this.semesterNo = semesterNo;
        this.semesterModule = semesterModule;
        this.semesterGPA = semesterGPA;
        this.cumulativeGPA = cumulativeGPA;
        this.training=training;
    }

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

    public StudentCategory getStudentCategory() {
        return studentCategory;
    }

    public void setStudentCategory(StudentCategory studentCategory) {
        this.studentCategory = studentCategory;
    }

    public String getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(String semesterNo) {
        this.semesterNo = semesterNo;
    }

    public ArrayList<Module> getSemesterModule() {
        return semesterModule;
    }

    public void setSemesterModule(ArrayList<Module> semesterModule) {
        this.semesterModule = semesterModule;
    }

    public Float getSemesterGPA() {
        return semesterGPA;
    }

    public void setSemesterGPA(Float semesterGPA) {
        this.semesterGPA = semesterGPA;
    }

    public Float getCumulativeGPA() {
        return cumulativeGPA;
    }

    public void setCumulativeGPA(Float cumulativeGPA) {
        this.cumulativeGPA = cumulativeGPA;
    }

    public Boolean getTraining() {
        return training;
    }

    public void setTraining(Boolean training) {
        this.training = training;
    }
}