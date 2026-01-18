package com.cfs.securityp04.Controller;

import com.cfs.securityp04.DTO.UserRequestList;
import com.cfs.securityp04.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Democontroller {


    @Autowired
    private userService userService;

    @PostMapping("/adduser")
    public String addusermethod(@RequestBody UserRequestList list){
        userService.saveUser(list.getUser());
        return  " User Added Susscesfully ....";
    }

    @GetMapping("/user")
    public String  usermethod(){
        return " user method called .";
    }

    @GetMapping("/admin")
    public String  adminmethod(){
        return " admin method called .";
    }

    @GetMapping("/public")
    public String  publicmethod(){
        return " public  method called .   anyone can accses it .";
    }
}
