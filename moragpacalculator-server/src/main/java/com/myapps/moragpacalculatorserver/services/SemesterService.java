package com.myapps.moragpacalculatorserver.services;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.Semester;
import com.myapps.moragpacalculatorserver.dataModels.SemesterDefinition;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;

import java.util.ArrayList;

public interface SemesterService {
    //Object createDefaultSemester(String userId, StudentCategory studentCategory, String SemesterNo, ArrayList<Module> moduleArrayList);
    //ResponseEntity<Semester> updateSemester(String userId,Semester semester);
    ArrayList<Semester> createSemesters(String userId, StudentCategory studentCategory, ArrayList<SemesterDefinition> semesterDefinitionArrayList);

}
