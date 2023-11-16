package com.project.booklibrary.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
  @GetMapping("/")
  public String index(){
    return "index";
  }
  @GetMapping("/login")
  public String Login(){
    return "login";
  }
  @PostMapping("/login/home")
  public String loginAuthentication(@RequestParam String username,@RequestParam String password){
    
    if(username.equals("Nahin")&&password.equals("Nahin@2022")){
      return "home";
    }
    return "login";
  }
}

