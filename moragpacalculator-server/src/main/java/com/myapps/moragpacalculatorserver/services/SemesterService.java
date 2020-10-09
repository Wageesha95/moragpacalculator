package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.Semester;
import com.myapps.moragpacalculatorserver.dataModels.SemesterDefinition;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface SemesterService {
    //Object createDefaultSemester(String userId, StudentCategory studentCategory, String SemesterNo, ArrayList<Module> moduleArrayList);
    //ResponseEntity<Semester> updateSemester(String userId,Semester semester);
    ArrayList<Semester> createSemesters(String userId, StudentCategory studentCategory, ArrayList<SemesterDefinition> semesterDefinitionArrayList);
    ResponseEntity<List<Semester>> getAllSemesters();
    ResponseEntity<Semester> updateSemester(Semester semester);
}
