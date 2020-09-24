package com.sangeetha.roompoc.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookWithAuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bookWithAuthor: BookAndAuthorEntity)

    @Transaction
    @Query("SELECT * FROM BookEntity")
    fun getBookWithAuthors(): LiveData<List<BookWithAuthors>>

    @Delete
    fun delete(bookWithAuthor: BookAndAuthorEntity)
}
