package com.myapps.moragpacalculatorserver.controller;

import com.myapps.moragpacalculatorserver.dataModels.UserProfile;
import com.myapps.moragpacalculatorserver.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @Autowired
    private UserProfileService userProfileService;


    @PostMapping("/signup")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserProfile> newUserRegistration(@RequestBody UserProfile userProfile) {
        return userProfileService.newUserRegistration(userProfile);
    }
    //signin
}
