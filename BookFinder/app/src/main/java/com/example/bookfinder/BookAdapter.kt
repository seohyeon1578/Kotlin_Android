package com.example.bookfinder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(val context:Context):RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    var books:ArrayList<Book>
    init {
        books = ArrayList()
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        val textTitle: TextView
        val textPublisher: TextView

        init {
            imageView = view.findViewById(R.id.imageView)
            textTitle = view.findViewById(R.id.textView2)
            textPublisher = view.findViewById(R.id.textView3)
        }
    }

    fun add(book:Book) {
        books.add(book)
    }

    fun clear() {
        books.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.book_layout, parent, false)
        val holder = ViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val book = books[position]
        //holder.imageView
        holder.textTitle.text = book.title
        holder.textPublisher.text = book.publisher
    }

    override fun getItemCount(): Int {
        return books.size
    }
}