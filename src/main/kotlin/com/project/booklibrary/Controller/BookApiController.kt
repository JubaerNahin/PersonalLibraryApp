package com.project.booklibrary.Controller

import com.project.booklibrary.Entity.Book
import com.project.booklibrary.Entity.DoneReading
import com.project.booklibrary.Entity.Wishlist
import com.project.booklibrary.Repository.BookRepository
import com.project.booklibrary.Repository.DoneReadingRepository
import com.project.booklibrary.Repository.WishlistRepository
import com.project.booklibrary.Service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Kotlin REST API Controller for mobile (Android) and client integrations.
 * Demonstrates Java & Kotlin interoperability within the Spring Boot ecosystem.
 */
@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = ["*"])
class BookApiController(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val wishlistRepository: WishlistRepository,
    private val doneReadingRepository: DoneReadingRepository
) {

    @GetMapping
    fun getAllBooks(): List<Book> = bookService.getallBooks()

    @GetMapping("/{sl}")
    fun getBookById(@PathVariable sl: Long): ResponseEntity<Book> {
        val book = bookRepository.findById(sl)
        return if (book.isPresent) {
            ResponseEntity.ok(book.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun addBook(@RequestBody book: Book): ResponseEntity<Book> {
        val saved = bookService.addBook(book)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @DeleteMapping("/{sl}")
    fun deleteBook(@PathVariable sl: Long): ResponseEntity<Void> {
        bookService.deleteBook(sl)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/wishlist")
    fun getAllWishlists(): List<Wishlist> = bookService.getallWishlists()

    @PostMapping("/wishlist/{sl}")
    fun moveToWishlist(@PathVariable sl: Long): ResponseEntity<Wishlist> {
        val optionalBook = bookRepository.findById(sl)
        if (optionalBook.isEmpty) {
            return ResponseEntity.notFound().build()
        }
        val book = optionalBook.get()
        val wishlist = Wishlist().apply {
            this.sl = book.sl
            authname = book.authname
            bookname = book.bookname
            booksummary = book.booksummary
        }
        val saved = wishlistRepository.save(wishlist)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @DeleteMapping("/wishlist/{sl}")
    fun deleteWishlist(@PathVariable sl: Long): ResponseEntity<Void> {
        bookService.deleteWishlist(sl)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/donereading")
    fun getAllDoneReadings(): List<DoneReading> = bookService.getallDoneReadings()

    @PostMapping("/donereading/{sl}")
    fun moveToDoneReading(@PathVariable sl: Long): ResponseEntity<DoneReading> {
        val optionalBook = bookRepository.findById(sl)
        if (optionalBook.isEmpty) {
            return ResponseEntity.notFound().build()
        }
        val book = optionalBook.get()
        val doneReading = DoneReading().apply {
            this.sl = book.sl
            authname = book.authname
            bookname = book.bookname
            booksummary = book.booksummary
        }
        val saved = doneReadingRepository.save(doneReading)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @DeleteMapping("/donereading/{sl}")
    fun deleteDoneReading(@PathVariable sl: Long): ResponseEntity<Void> {
        bookService.deleteDonereading(sl)
        return ResponseEntity.noContent().build()
    }
}
