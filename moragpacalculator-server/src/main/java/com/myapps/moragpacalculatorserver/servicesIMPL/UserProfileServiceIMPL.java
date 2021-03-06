package com.myapps.moragpacalculatorserver.servicesIMPL;

import com.myapps.moragpacalculatorserver.dataModels.UserProfile;
import com.myapps.moragpacalculatorserver.repositories.UserProfileRepository;
import com.myapps.moragpacalculatorserver.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileServiceIMPL implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public ResponseEntity<UserProfile> newUserRegistration(UserProfile userProfile) {
        try {
            UserProfile _userProfile = new UserProfile(userProfile.getName());
            userProfileRepository.save(_userProfile);
            return new ResponseEntity<>(_userProfile, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
    public UserProfile getUserProfile(String profileId) {
        try {
            Optional<UserProfile> userProfile = userProfileRepository.findById(profileId);
            UserProfile _userProfile = userProfile.get();
            return _userProfile;
        } catch (Exception e) {
            throw e;
        }
    }
}