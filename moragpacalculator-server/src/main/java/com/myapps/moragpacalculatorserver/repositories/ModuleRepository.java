package com.myapps.moragpacalculatorserver.repositories;

import com.myapps.moragpacalculatorserver.dataModels.Module;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ModuleRepository extends MongoRepository<Module,String> {
 //   @Query(value = "{ 'roles.id' : ?0 }")
//        List<User> findByRole(String roleId);
 //@Query("SELECT m FROM Module m where m.userId = ?1 AND m.elective = ?2")
 @Query(value = "{ 'userId' : ?0, 'elective':?1, 'enrollment' : ?2 }")
    ArrayList<Module> findAllByUserIdAndElectiveAndEnrollment(String profileId,Boolean elective,Boolean enrollment);

}
