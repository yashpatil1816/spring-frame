package com.cfs.securityp04.Repo;

import com.cfs.securityp04.Entity.appUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<appUser,String> {

    Optional<appUser> findByName(String name); // this is written beacuse uer can be presnt or not , if we
    // dont write this , then it returns null , i cause NPI exception , // aslo this is our custome method ,
}
