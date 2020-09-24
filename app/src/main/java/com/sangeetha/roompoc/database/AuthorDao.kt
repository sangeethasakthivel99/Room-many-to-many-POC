package com.sangeetha.roompoc.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(author: AuthorEntity)

    @Delete
    fun deleteBook(author: AuthorEntity)
}
