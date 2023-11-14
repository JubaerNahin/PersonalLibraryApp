package com.project.booklibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.booklibrary.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
  
}
