package com.myapps.moragpacalculatorserver.dataModels;

import java.util.ArrayList;

public class SemesterDefinition {

    private String semesterNo;
    private String description;
    private Integer maxNoOfModules;
    private Integer minNoOfModules;
    private ArrayList<String> moduleCodes;

    public SemesterDefinition() {
    }

    public String getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(String semester) {
        this.semesterNo = semester;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxNoOfModules() {
        return maxNoOfModules;
    }

    public void setMaxNoOfModules(Integer maxNoOfModules) {
        this.maxNoOfModules = maxNoOfModules;
    }

    public Integer getMinNoOfModules() {
        return minNoOfModules;
    }

    public void setMinNoOfModules(Integer minNoOfModules) {
        this.minNoOfModules = minNoOfModules;
    }

    public ArrayList<String> getModuleCodes() {
        return moduleCodes;
    }

    public void setModuleCodes(ArrayList<String> moduleCodes) {
        this.moduleCodes = moduleCodes;
    }
}
