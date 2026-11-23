package com.example.personallibraryandroidapp.network

import com.example.personallibraryandroidapp.data.Book
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface BookApiService {
    @GET("api/books")
    suspend fun getBooks(): List<Book>

    @POST("api/books")
    suspend fun addBook(@Body book: Book): Book

    @DELETE("api/books/{sl}")
    suspend fun deleteBook(@Path("sl") sl: Long)

    @POST("api/books/wishlist/{sl}")
    suspend fun moveToWishlist(@Path("sl") sl: Long)

    companion object {
        // 10.0.2.2 points to localhost of the computer running the emulator.
        // For a physical phone, replace with your PC local LAN IP (e.g. http://192.168.1.15:8081/)
        private const val BASE_URL = "http://10.0.2.2:8081/"

        fun create(): BookApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookApiService::class.java)
        }
    }
}
