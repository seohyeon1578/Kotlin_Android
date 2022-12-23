package com.example.xmlparsing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AttrAdapter(val context:Context):RecyclerView.Adapter<AttrAdapter.ViewHolder>() {
    val atts:ArrayList<Attracct>

    init {
        this.atts = ArrayList()
    }

    fun add(att: Attracct) {
        atts.add(att)
    }

    fun clear() {
        atts.clear()
    }

    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val textName:TextView
        val textAddr: TextView
        init {
            textName = view.findViewById(R.id.textName)
            textAddr = view.findViewById(R.id.textAddr)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val att = atts[position]
        holder.textName.text = att.name
        holder.textAddr.text = att.address
    }

    override fun getItemCount(): Int {
        return this.atts.size
    }
}