package com.project.booklibrary.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.booklibrary.Entity.Book;
import com.project.booklibrary.Entity.Wishlist;
import com.project.booklibrary.Repository.BookRepository;
import com.project.booklibrary.Repository.DoneReadingRepository;
import com.project.booklibrary.Repository.WishlistRepository;
import com.project.booklibrary.Service.BookService;

@Controller
public class BookController {
  @Autowired
 
  private BookService bookService;
  @Autowired
  private  BookRepository bookRepository;
  @Autowired
  private  WishlistRepository wishlistRepository;
  @Autowired
  private  DoneReadingRepository doneReadingRepository;
  
  @GetMapping("/login/home")
  public String home(Model model) {
    model.addAttribute("book", bookService.getallBooks());
    return "home";
  }

  @GetMapping("/login/home/donereading")
  public String donereading(Model model) {
    model.addAttribute("donereading", bookService.getallDoneReadings());
    return "done_reading";
  }

  @GetMapping("/login/home/wishlist")
  public String wishlist(Model model) {
    model.addAttribute("wishlist", bookService.getallWishlists());
    return "wishlist";
  }

  @GetMapping("/login/home/{sl}")
  public String DeleteBook(@PathVariable Long sl) {
    bookService.deleteBook(sl);
    return "redirect:/login/home";
  }

  @GetMapping("/login/home/addongoing")
  public String addOngoing(Model model) {
    Book book = new Book();
    model.addAttribute("book", book);
    return "add_ongoing";
  }

  @PostMapping("/login/home")
  public String addOngoing(@ModelAttribute("book") Book book){
    bookService.addBook(book);
    return "redirect:/login/home";
  }
   
  @GetMapping("/login/home/wishlist1/{sl}")
  public String MoveToWishlist(@PathVariable Long sl){
    Optional<Book> optionalbook = bookRepository.findById(sl);   
    Book book = optionalbook.get();
    Wishlist wishlist = new Wishlist();  
    wishlist.setSl(book.getSl());
    wishlist.setAuthname(book.getAuthname());
    wishlist.setBookname(book.getBookname());
    wishlist.setBooksummary(book.getBooksummary());

    wishlistRepository.save(wishlist);
    return "redirect:/login/home";
  }
}
