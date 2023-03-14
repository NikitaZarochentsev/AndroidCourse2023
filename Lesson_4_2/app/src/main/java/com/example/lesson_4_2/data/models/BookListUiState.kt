package com.example.lesson_4_2.data.models

data class BookListUiState(
    var authorListResult: List<AuthorInfo>
)

data class AuthorInfo(
    var nameAuthor: String,
    var bookList: List<BookInfo>
)

data class BookInfo(
    var nameBook: String,
    var availability: Boolean
)
