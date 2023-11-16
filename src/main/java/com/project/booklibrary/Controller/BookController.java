package com.project.booklibrary.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.booklibrary.Service.BookService;

@Controller
public class BookController {
  @Autowired
  private BookService bookService;

   @GetMapping("/login/home/addongoing")
   public String addongoing(Model model){
    return "add_ongoing";
  }
  @GetMapping("/login/home/donereading")
  public String donereading(Model model){
    return "done_reading";
  }
  @GetMapping("/login/home/wishlist")
   public String wishlist(Model model){
    return "wishlist";
  }
}
