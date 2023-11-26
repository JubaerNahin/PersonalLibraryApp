package com.project.booklibrary.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.booklibrary.Entity.Book;
import com.project.booklibrary.Entity.DoneReading;
import com.project.booklibrary.Entity.Wishlist;
import com.project.booklibrary.Repository.BookRepository;
import com.project.booklibrary.Repository.DoneReadingRepository;
import com.project.booklibrary.Repository.WishlistRepository;
import com.project.booklibrary.Service.BookService;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
	private BookRepository bookRepository;
	@Autowired
	private DoneReadingRepository doneReadingRepository;
	@Autowired
	private WishlistRepository wishlistRepository;


  

  public BookServiceImpl() {
	}
	public BookServiceImpl(DoneReadingRepository doneReadingRepository, WishlistRepository wishlistRepository) {
		super();
		this.doneReadingRepository = doneReadingRepository;
		this.wishlistRepository = wishlistRepository;
	}
	public BookServiceImpl(BookRepository bookRepository) {
    super();
    this.bookRepository = bookRepository;
  }
  @Override
  public List<Book> getallBooks(){
    return bookRepository.findAll();
  }
  @Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	@Override
	public Book getBookBysl(Long sl) {
		return bookRepository.findById(sl).get();
	}

	@Override
	public void MoveToWishlist(Long sl) {
		
	}

	@Override
	public void deleteBook(Long sl) {
		bookRepository.deleteById(sl);
	}

	@Override
	public void deleteWishlist(Long sl) {
		wishlistRepository.deleteById(sl);
	}

	@Override
	public void deleteDonereading(Long sl) {
		doneReadingRepository.deleteById(sl);
	}
	@Override
	public List<Wishlist> getallWishlists(){
	     return	wishlistRepository.findAll();
	}

	@Override
	public List<DoneReading> getallDoneReadings(){
	     return	doneReadingRepository.findAll();
	}
	
}
