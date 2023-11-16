package com.project.booklibrary.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.booklibrary.Entity.Book;
import com.project.booklibrary.Repository.BookRepository;
import com.project.booklibrary.Service.BookService;

@Service
public class BookServiceImpl implements BookService{
  private BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    super();
    this.bookRepository = bookRepository;
  }
  @Override
  public List<Book> getallBooks(){
    return bookRepository.findAll();
  }
}
