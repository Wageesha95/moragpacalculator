package com.myapps.moragpacalculatorserver.dataModels;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection ="Module_Definitions")
public class ModuleDefinition {

    @Id
    private String id;
    private String module_code;
    private String module_name;
    private Float module_credits;
    private Boolean gpa;
    private Boolean elective;
    private Float result;

    public ModuleDefinition() {
    }

    public ModuleDefinition(String module_code, String module_name, Float module_credits, Boolean gpa, Boolean elective) {
        this.module_code = module_code;
        this.module_name = module_name;
        this.module_credits = module_credits;
        this.gpa = gpa;
        this.elective = elective;
    }

    public ModuleDefinition(String module_code, String module_name, Float module_credits, Boolean gpa, Boolean elective, Float result) {
        this.module_code = module_code;
        this.module_name = module_name;
        this.module_credits = module_credits;
        this.gpa = gpa;
        this.elective = elective;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule_code() {
        return module_code;
    }

    public void setModule_code(String module_code) {
        this.module_code = module_code;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public Float getModule_credits() {
        return module_credits;
    }

    public void setModule_credits(Float module_credits) {
        this.module_credits = module_credits;
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

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        this.result = result;
    }
}
