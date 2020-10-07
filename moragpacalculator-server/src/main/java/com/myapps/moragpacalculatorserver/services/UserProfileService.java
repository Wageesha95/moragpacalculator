package com.myapps.moragpacalculatorserver.services;


import com.myapps.moragpacalculatorserver.dataModels.UserProfile;
import org.springframework.http.ResponseEntity;

public interface UserProfileService {
    ResponseEntity<UserProfile> newUserRegistration(UserProfile userProfile);
}
