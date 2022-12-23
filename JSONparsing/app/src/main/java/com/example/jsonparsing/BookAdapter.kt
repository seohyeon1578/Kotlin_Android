package com.example.jsonparsing

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BookAdapter(val context: Context):RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    val books: ArrayList<Book>

    init {
        this.books = ArrayList()
    }

    fun add(book:Book) {
        books.add(book)
    }

    fun clear() {
        books.clear()
    }

    fun item(pos:Int): Book {
        return books[pos]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_book, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        Glide.with(holder.itemView.context).load(book.thumbnail).into(holder.imageItem)
        holder.textTitle.text = book.title
        holder.textPublic.text = book.publisher
        holder.textAuth.text = book.authors
        holder.textPrice.text = "${book.price}원"
    }

    override fun getItemCount(): Int {
        return this.books.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageItem: ImageView
        val textTitle: TextView
        val textPublic: TextView
        val textAuth: TextView
        val textPrice: TextView

        init {
            imageItem = view.findViewById(R.id.imageItem)
            textTitle = view.findViewById(R.id.textName)
            textPublic = view.findViewById(R.id.textPubli)
            textAuth = view.findViewById(R.id.textAuth)
            textPrice = view.findViewById(R.id.textPrice)

            view.setOnClickListener {
                val pos = adapterPosition

                if(pos != RecyclerView.NO_POSITION){
                    val book = item(pos)
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("url", book.url)
                    context.startActivity(intent)
                }
            }
        }
    }
}