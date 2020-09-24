package com.sangeetha.roompoc.database

import androidx.room.*

@Dao
interface BookWithAuthorDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(bookWithAuthor: BookWithAuthorEntity)

    @Transaction
    @Query("SELECT * FROM BookEntity")
    fun getCourses(): List<CourseInstructorPair>

    @Delete
    fun delete(bookWithAuthor: BookWithAuthorEntity)
}
