package com.sangeetha.roompoc.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        BookEntity::class,
        AuthorEntity::class,
        BookWithAuthorEntity::class
    ]
)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookWithAuthorDao(): BookWithAuthorDao
    abstract fun bookDao(): BookDao
    abstract fun authorDao(): AuthorDao

    companion object {
        private lateinit var INSTANCE: BookDatabase

        operator fun invoke(context: Context): BookDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    BookDatabase::class.java, "book_database"
                ).build()
            }
            return INSTANCE
        }
    }
}
