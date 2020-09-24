package com.sangeetha.roompoc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sangeetha.roompoc.database.BookWithAuthors
import kotlinx.android.synthetic.main.item_books.view.*


class BookAdapter(private val bookWithAuthor: List<BookWithAuthors>): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_books, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val bookWithAuthor = bookWithAuthor[position]
        holder.bind(bookWithAuthor)
    }

    override fun getItemCount(): Int {
       return bookWithAuthor.size
    }

    class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: BookWithAuthors) {
            itemView.bookTitle.text = item.book.bookTitle
            var authorName: String? = ""
            item.author.forEach {
                authorName += it.authorName + "   "
            }
            itemView.author.text = authorName
        }
    }
}