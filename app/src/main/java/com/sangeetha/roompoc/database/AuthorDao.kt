package com.sangeetha.roompoc.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface AuthorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(author: AuthorEntity)

    @Delete
    fun deleteBook(author: AuthorEntity)
}
