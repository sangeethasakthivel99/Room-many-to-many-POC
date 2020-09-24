package com.sangeetha.roompoc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sangeetha.roompoc.database.BookWithAuthors
import com.sangeetha.roompoc.repository.BookRepository

class BookViewModel(private val repository: BookRepository): ViewModel() {
    fun fetchData(): LiveData<List<BookWithAuthors>> {
        repository.insertToDB()
        return repository.fetch()
    }
}