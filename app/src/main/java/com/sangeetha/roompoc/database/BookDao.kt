package com.sangeetha.roompoc.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBook(book: BookEntity)

    @Delete
    fun deleteBook(book: BookEntity)
}
