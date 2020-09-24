package com.sangeetha.roompoc.database

import androidx.room.*

@Dao
interface BookWithAuthorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(bookWithAuthor: BookAndAuthorEntity)

    @Transaction
    @Query("SELECT * FROM BookEntity")
    fun getBookWithAuthors(): List<BookWithAuthors>

    @Delete
    fun delete(bookWithAuthor: BookAndAuthorEntity)
}
