package com.myapps.moragpacalculatorserver.repositories;

import com.myapps.moragpacalculatorserver.dataModels.Student;
import com.myapps.moragpacalculatorserver.dataModels.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface StudentRepository extends MongoRepository<Student,UserProfile> {

    Optional<Student> findByUserProfile(UserProfile userProfile);
//        Optional<User> findByEmail(String username);
//
//        Boolean existsByUsername(String username);
//
//        Boolean existsByEmail(String email);
//
//        User findUserById(String userId);
//
//        @Query(value = "{ 'roles.id' : ?0 }")
//        List<User> findByRole(String roleId);
//



}
