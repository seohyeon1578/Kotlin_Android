package com.example.catar2022recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context, val nations:ArrayList<Nation>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    inner class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val imageFlag: ImageView
        val textName: TextView
        val textGroup: TextView

        init {
            imageFlag = view.findViewById(R.id.image_flag)
            textName = view.findViewById(R.id.text_name)
            textGroup = view.findViewById(R.id.text_group)

            view.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    val nation = nations[position]

                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("nation", nation)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_item, parent, false)
        val holder = ViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nation = nations[position]

        holder.imageFlag.setImageResource(nation.flag)
        holder.textName.text = nation.name
        holder.textGroup.text = "Group ${nation.group}"
    }

    override fun getItemCount(): Int {
        return nations.size
    }
}