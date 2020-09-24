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
        Book(listOf(7),BookEntity(1,"Alchemist")),
        Book(listOf(2),BookEntity(2,"Wings of Fire")),
        Book(listOf(2),BookEntity(3,"India 2020")),
        Book(listOf(3),BookEntity(4,"Clean Code")),
        Book(listOf(3),BookEntity(5,"Clean Coder")),
        Book(listOf(4,5),BookEntity(6,"Aurora Rising")),
        Book(listOf(), BookEntity(7, "Secret")),
        Book(listOf(),BookEntity(8, "Rich Dad Poor Dad"))

    ),
    listOf(
        AuthorEntity(2,"Abdul Kalam"),
        AuthorEntity(3,"Robert C Martin"),
        AuthorEntity(4,"Amie Kaufman"),
        AuthorEntity(5,"Jay Kristoff"),
        AuthorEntity(6, "Helen"),
        AuthorEntity(7,"Paulo Cohelo")
    )
)