package com.project.booklibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.booklibrary.Entity.Book;
import com.project.booklibrary.Repository.BookRepository;

@SpringBootApplication
public class BooklibraryApplication{

	public static void main(String[] args) {
		SpringApplication.run(BooklibraryApplication.class, args);
	}
	@Autowired
  private BookRepository bookRepository;
	// @Override
	// public void run(String... args) throws Exception {
	// 	Book book1 = new Book("Atomic Habit","James Clear","Non-fiction");
  //   bookRepository.save(book1);
	// 		Book book2 = new Book("Atomic Habit","James Clear","Non-fiction");
  //   bookRepository.save(book2);
	// }

}
