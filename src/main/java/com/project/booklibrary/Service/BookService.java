package com.project.booklibrary.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.booklibrary.Entity.Book;
import com.project.booklibrary.Entity.DoneReading;
import com.project.booklibrary.Entity.Wishlist;

@Service
public interface BookService {
    public List<Book> getallBooks();
    
    public Book addBook(Book book);

    public Book getBookBysl(Long sl);

    public void MoveToWishlist(Long sl);

    public void deleteBook(Long sl);

    public void deleteWishlist(Long sl);

    public void deleteDonereading(Long sl);

    public List<Wishlist> getallWishlists();

    public List<DoneReading> getallDoneReadings();
}
