package com.sangeetha.roompoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sangeetha.roompoc.database.BookWithAuthors
import com.sangeetha.roompoc.repository.BookRepository
import com.sangeetha.roompoc.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BookViewModel

    private var bookWithAuthors: MutableList<BookWithAuthors> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        observeData()
        initRecyclerView()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, object: ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return BookViewModel(BookRepository(this@MainActivity)) as T
            }
        }).get(BookViewModel::class.java)
    }

    private fun observeData() {
        viewModel.fetchData().observe(this, Observer {
            it.forEach { bookAndAuthors ->
                bookWithAuthors.add(bookAndAuthors)
            }
        })
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = BookAdapter(bookWithAuthors)
        }
    }
}