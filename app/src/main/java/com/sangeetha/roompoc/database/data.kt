package com.sangeetha.roompoc.database

data class BookResponse(
    val books: List<Book>? = null,
    val authors: List<AuthorEntity>? = null
)

data class Book (
    val authors: List<Long>? = null,
    val books: BookEntity? = null
)

val response = BookResponse(
    listOf(
        Book(listOf(1),BookEntity(1,"Alchemist")),
        Book(listOf(2),BookEntity(2,"Wings of Fire")),
        Book(listOf(2),BookEntity(3,"India 2020")),
        Book(listOf(3),BookEntity(4,"Clean Code")),
        Book(listOf(3),BookEntity(5,"Clean Coder")),
        Book(listOf(4,5),BookEntity(6,"Aurora Rising"))

    ),
    listOf(
        AuthorEntity(1,"Paulo Coelho"),
        AuthorEntity(2,"Abdul Kalam"),
        AuthorEntity(3,"Robert C Martin"),
        AuthorEntity(4,"Amie Kaufman"),
        AuthorEntity(5,"Jay Kristoff")
    )
)