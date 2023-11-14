package com.project.booklibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.booklibrary.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
  
}
