package com.cfs.Security_P01.bankController;

import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class bnkController {



  int bal = 1000;

    @GetMapping("/balance")
    public int getbalance(){
        return bal;
    }

    @PostMapping("/add")
    public int updatebalnce(@RequestParam int val){
     return bal+val;

    }

    @GetMapping("/contact")
    public String contactUS(){
        return "you can conatct us : 32883632832";
    }
}
