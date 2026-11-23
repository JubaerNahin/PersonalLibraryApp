package com.example.personallibraryandroidapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personallibraryandroidapp.data.Book
import com.example.personallibraryandroidapp.network.BookApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface BookUiState {
    object Loading : BookUiState
    data class Success(val books: List<Book>) : BookUiState
    data class Error(val message: String) : BookUiState
}

class BookViewModel(
    private val apiService: BookApiService = BookApiService.create()
) : ViewModel() {

    private val _uiState = MutableStateFlow<BookUiState>(BookUiState.Loading)
    val uiState: StateFlow<BookUiState> = _uiState.asStateFlow()

    init {
        loadBooks()
    }

    fun loadBooks() {
        viewModelScope.launch {
            _uiState.value = BookUiState.Loading
            try {
                val books = apiService.getBooks()
                _uiState.value = BookUiState.Success(books)
            } catch (e: Exception) {
                _uiState.value = BookUiState.Error(
                    e.localizedMessage ?: "Failed to connect to backend. Make sure Spring Boot is running on port 8081!"
                )
            }
        }
    }

    fun addBook(bookname: String, authname: String, summary: String) {
        viewModelScope.launch {
            try {
                apiService.addBook(Book(bookname = bookname, authname = authname, booksummary = summary))
                loadBooks()
            } catch (e: Exception) {
                _uiState.value = BookUiState.Error("Failed to add book: ${e.localizedMessage}")
            }
        }
    }

    fun deleteBook(sl: Long) {
        viewModelScope.launch {
            try {
                apiService.deleteBook(sl)
                loadBooks()
            } catch (e: Exception) {
                _uiState.value = BookUiState.Error("Failed to delete book: ${e.localizedMessage}")
            }
        }
    }

    fun moveToWishlist(sl: Long) {
        viewModelScope.launch {
            try {
                apiService.moveToWishlist(sl)
                loadBooks()
            } catch (e: Exception) {
                _uiState.value = BookUiState.Error("Failed to move to wishlist: ${e.localizedMessage}")
            }
        }
    }
}
