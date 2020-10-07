package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

//    @PostMapping("/{userId}/semester")
//    //@PreAuthorize("hasRole('USER')")
//    public ResponseEntity<Semester> updateSemester( @PathVariable("userId") String userId, @RequestBody Semester semester) {
//        return semesterService.updateSemester(userId,Semester);
//    }

}
