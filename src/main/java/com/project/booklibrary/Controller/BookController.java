package com.project.booklibrary.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
  
  @PostMapping("/login/home")
  public String loginAuthentication(@RequestParam String username,@RequestParam String password){
    if(username.equals("Lipa")&&password.equals("Lipa987@#")){
      return "home";
    }
    return "login";
  }
}
