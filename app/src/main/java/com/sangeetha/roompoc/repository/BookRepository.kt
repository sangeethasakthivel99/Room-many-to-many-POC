package com.sangeetha.roompoc.repository

import android.content.Context
import android.util.Log
import com.sangeetha.roompoc.database.BookAndAuthorEntity
import com.sangeetha.roompoc.database.BookDatabase
import com.sangeetha.roompoc.database.response

class BookRepository(private val context: Context) {

    private val bookDao = BookDatabase(context).bookDao()
    private val authorDao = BookDatabase(context).authorDao()
    private val bookWithAuthorDao = BookDatabase(context).bookWithAuthorDao()

    private var bookWithAuthorsList: MutableList<BookAndAuthorEntity> = mutableListOf()

    fun insertToDB() {
        response.books?.forEach{
            it.books?.let { book -> bookDao.insertBook(book) }
        }
        response.authors?.forEach {
            authorDao.insert(it)
        }

        response.books?.forEach { book ->
            book.authors?.forEach {authorId ->
                book.books?.bookId?.let { bookId -> BookAndAuthorEntity(bookId, authorId) }?.let { bookAndAuthorId ->
                    bookWithAuthorsList.add(bookAndAuthorId)
                }
            }
        }

        bookWithAuthorsList.forEach {
            bookWithAuthorDao.insert(it)
        }
    }

    fun fetch() {
        val data = bookWithAuthorDao.getBookWithAuthors()
        data.forEach {
            Log.d("BookWithAuthors", it.toString())
        }
    }
}