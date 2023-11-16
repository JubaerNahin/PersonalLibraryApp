package com.project.booklibrary.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.booklibrary.Entity.Book;

@Service
public interface BookService {
    public List<Book> getallBooks();
}
