package com.myapps.moragpacalculatorserver.dataModels;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection ="Module_Definitions")
public class ModuleDefinition {

    @Id
    private String id;
    private String moduleCode;
    private String moduleName;
    private Float moduleCredits;
    private Boolean gpa;
    private Boolean elective;


    public ModuleDefinition() {
    }

    public ModuleDefinition(String moduleCode, String moduleName, Float moduleCredits, Boolean gpa, Boolean elective) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.moduleCredits = moduleCredits;
        this.gpa = gpa;
        this.elective = elective;
    }

//    public ModuleDefinition(ModuleDefinition moduleDefinition) {
//        this.moduleCode = moduleDefinition.getModuleCode();
//        this.moduleName = moduleDefinition.getModuleName();
//        this.moduleCredits = moduleDefinition.getModuleCredits();
//        this.gpa = moduleDefinition.getGpa();
//        this.elective = moduleDefinition.getElective();
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Float getModuleCredits() {
        return moduleCredits;
    }

    public void setModuleCredits(Float moduleCredits) {
        this.moduleCredits = moduleCredits;
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
