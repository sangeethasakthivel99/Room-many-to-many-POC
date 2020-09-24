package com.sangeetha.roompoc.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBook(book: BookEntity)

    @Delete
    fun deleteBook(book: BookEntity)
}
