package com.project.booklibrary.Service.Impl;

import com.project.booklibrary.Repository.BookRepository;
import com.project.booklibrary.Service.BookService;

public class BookServiceImpl implements BookService{
  private BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    super();
    this.bookRepository = bookRepository;
  }
  
}
