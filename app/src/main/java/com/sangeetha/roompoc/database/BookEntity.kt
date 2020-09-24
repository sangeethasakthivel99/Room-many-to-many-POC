package com.sangeetha.roompoc.database

import androidx.room.*

@Entity
data class BookEntity (
    @PrimaryKey
    val bookId: Long = 0L,
    val bookTitle: String? = null
)

@Entity
data class AuthorEntity (
    @PrimaryKey
    val authorId: Long = 0L,
    val authorName: String? = null
)

@Entity(primaryKeys = ["bookId","authorId"])
data class BookAndAuthorEntity (
    val bookId: Long,
    val authorId: Long
)

data class BookWithAuthors(
    @Embedded
    var book: BookEntity,

    @Relation(
        parentColumn = "bookId",
        entity = AuthorEntity::class,
        entityColumn = "authorId",
        associateBy = Junction(
            value = BookAndAuthorEntity::class,
            parentColumn = "bookId",
            entityColumn = "authorId"
        )
    )
    var author: List<AuthorEntity>
)
