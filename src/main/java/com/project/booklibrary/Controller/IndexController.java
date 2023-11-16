package com.project.booklibrary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.booklibrary.Service.BookService;

@Controller
public class IndexController {
  @Autowired
  private BookService bookService;
  @GetMapping("/")
  public String index(){
    return "index";
  }
  @GetMapping("/login")
  public String Login(){
    return "login";
  }
  @PostMapping("/login")
  public String loginAuthentication(Model model,@RequestParam String username,@RequestParam String password){
    model.addAttribute("book", bookService.getallBooks());
    
    if(username.equals("Nahin")&&password.equals("Nahin@2022")){
      return "home";
    }
    return "login";
  }
}

