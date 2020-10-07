package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import com.myapps.moragpacalculatorserver.dataModels.StudentCategory;
import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

//    @PostMapping("/semester")
//    //@PreAuthorize("hasRole('USER')")
//    public ResponseEntity<List<Module>> getSemester(@RequestBody StudentCategory studentCategory) {
//        return semesterService.createSemester(studentCategory);
//    }

}
