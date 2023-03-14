package com.example.lesson_4_2.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_4_2.data.Author
import com.example.lesson_4_2.data.Book
import com.example.lesson_4_2.data.BookAvailability
import com.example.lesson_4_2.data.MockRepository
import com.example.lesson_4_2.data.models.AuthorInfo
import com.example.lesson_4_2.data.models.BookInfo
import com.example.lesson_4_2.data.models.BookListUiState
import kotlinx.coroutines.*

class BookViewModel() : ViewModel() {

    class GetBooksException : Exception()
    class GetAuthorsException : Exception()
    class GetAvailabilityException : Exception()

    val bookListUiState = MutableLiveData<Result<BookListUiState>>()

    private val mockRepository = MockRepository()
    private var booksList = listOf<Book>()
    private var authorsList = listOf<Author>()
    private var booksAvailabilityList = listOf<BookAvailability>()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        bookListUiState.value = Result.failure(throwable)
    }

    fun updateBookListUiState() {
        viewModelScope.launch(handler) {
            val booksResult = async {
                mockRepository.getBooks()
            }
            val authorsResult = async {
                mockRepository.getAuthors()
            }
            val availabilityResult = async {
                mockRepository.getAvailability()
            }

            booksResult.await()
                .onSuccess {
                    booksList = it
                }
                .onFailure {
                    throw GetBooksException()
                }
            authorsResult.await()
                .onSuccess { authors ->
                    authorsList = authors.sortedBy { it.name }
                }
                .onFailure {
                    throw GetAuthorsException()
                }
            availabilityResult.await()
                .onSuccess {
                    booksAvailabilityList = it
                }
                .onFailure {
                    throw GetAvailabilityException()
                }

            val authorInfoList = mutableListOf<AuthorInfo>()
            for (author in authorsList) {
                val bookOfAuthorList = booksList.filter {
                    it.authorId == author.authorId
                }.sortedBy {
                    it.title
                }
                val bookInfoList = mutableListOf<BookInfo>()
                for (bookOfAuthor in bookOfAuthorList) {
                    val bookOfAuthorAvailability = booksAvailabilityList.first {
                        it.bookId == bookOfAuthor.bookId
                    }
                    bookInfoList.add(
                        BookInfo(
                            bookOfAuthor.title,
                            bookOfAuthorAvailability.inStock
                        )
                    )
                }
                authorInfoList.add(AuthorInfo(author.name, bookInfoList))
            }

            bookListUiState.value = Result.success(BookListUiState(authorInfoList))
        }
    }
}