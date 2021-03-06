package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.Semester;
import com.myapps.moragpacalculatorserver.dataModels.Student;
import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @GetMapping("/semesters")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Semester>> getAllSemesters() {
        return semesterService.getAllSemesters();
    }

    @PutMapping("/semester")
    public ResponseEntity<Semester> updateSemester(@RequestBody Semester semester){
        return semesterService.updateSemester(semester);
    }



//    @PostMapping("/{userId}/semester")
//    //@PreAuthorize("hasRole('USER')")
//    public ResponseEntity<Semester> updateSemester( @PathVariable("userId") String userId, @RequestBody Semester semester) {
//        return semesterService.updateSemester(userId,Semester);
//    }

}
