package com.cfs.CSRF_example.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class userController {

private Map<String ,String> userdata = new HashMap<>();

@GetMapping("/public")
    public String publicmethod(){
    return "this is public method ";
}

@PostMapping("/adduser")
    public String adduser(@RequestBody Map<String,String> data ){
  userdata.put(data.get("username"),data.get("password"));
  return " user saved in the memory ";
}
}
