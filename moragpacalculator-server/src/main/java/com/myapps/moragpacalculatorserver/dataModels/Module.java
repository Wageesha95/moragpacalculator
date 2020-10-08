package com.myapps.moragpacalculatorserver.dataModels;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Modules")
public class Module {

    @Id
    private String id;
    private String userId;
    @DBRef
    private StudentCategory studentCategory;
    private String moduleCode;
    private String moduleName;
    private Float result;
    private Float credit;
    private Boolean gpa;
    private Boolean elective;

    public Module() {
    }

    public Module(String userId, StudentCategory studentCategory, String moduleCode, String moduleName, Float result, Float credit, Boolean gpa, Boolean elective) {
        this.userId = userId;
        this.studentCategory = studentCategory;
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.result = result;
        this.credit = credit;
        this.gpa = gpa;
        this.elective = elective;
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

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        this.result = result;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Boolean getGpa() {
        return gpa;
    }

    public void setGpa(Boolean gpa) {
        this.gpa = gpa;
    }

    public Boolean getElective() {
        return elective;
    }

    public void setElective(Boolean elective) {
        this.elective = elective;
    }
}