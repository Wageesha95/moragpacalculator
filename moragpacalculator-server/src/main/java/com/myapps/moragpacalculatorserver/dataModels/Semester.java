package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Semesters")
public class Semester {

    @Id
    private String id;
    private StudentCategory studentCategory;
    private String semester_number;
    private List<Module> semester_modules;


    public Semester(StudentCategory studentCategory, String semester_number, List<Module> semester_modules) {
        this.studentCategory = studentCategory;
        this.semester_number = semester_number;
        this.semester_modules = semester_modules;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudentCategory getStudentCategory() {
        return studentCategory;
    }

    public void setStudentCategory(StudentCategory studentCategory) {
        this.studentCategory = studentCategory;
    }

    public String getSemester_number() {
        return semester_number;
    }

    public void setSemester_number(String semester_number) {
        this.semester_number = semester_number;
    }

    public List<Module> getSemester_modules() {
        return semester_modules;
    }

    public void setSemester_modules(List<Module> semester_modules) {
        this.semester_modules = semester_modules;
    }
}
