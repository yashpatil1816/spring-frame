package com.cfs.securityp03_YP.Controller;

import com.cfs.securityp03_YP.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BankController {


    @Autowired
    AccountService service;

    @GetMapping("/balance")  //user
    public String getBalance()
    {
            return service.getBalance();
    }


    @GetMapping ("/close") //ADMIN
    public String closeAccount()
    {
            return service.closeAccount();
    }

    @GetMapping("/about")
    public String about()
    {
        return "hello ji hum lunch pe ha";
    }
}
