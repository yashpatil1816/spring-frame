package com.cfs.securityp04.Service;

import com.cfs.securityp04.DTO.UserRequestList;
import com.cfs.securityp04.DTO.userRequest;
import com.cfs.securityp04.Entity.appUser;
import com.cfs.securityp04.Entity.roles;
import com.cfs.securityp04.Repo.roleRepository;
import com.cfs.securityp04.Repo.userRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class userService {


    @Autowired
private userRepository userRepository;

    @Autowired
    private roleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



  @Transactional
    public void saveUser( List<userRequest> list){

        for( userRequest user: list){
            appUser appUser = new appUser();
            appUser.setEnabled(true);
            appUser.setName(user.getName());
            appUser.setPassword(passwordEncoder.encode(user.getPassword()));

            Set<roles> rolesSet = new HashSet<>();

       for(String rolename : user.getRole()){
           roles role = roleRepository.findByName(rolename)
                   .orElseGet(()->{
                     roles newrole =new roles();
                       newrole.setName(rolename);
                    return roleRepository.save(newrole);
                   });
         rolesSet.add(role);
       }

     appUser.setRole(rolesSet);
userRepository.save(appUser);
        }


    }
}
