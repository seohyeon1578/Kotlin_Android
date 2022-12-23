package com.example.recicylerviewtest

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TwiceAdapter(val context: Context, val members:ArrayList<Twice>):RecyclerView.Adapter<TwiceAdapter.ViewHolder>() {
    inner class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
        val imageMember: ImageView
        val textName: TextView
        val textNick: TextView
        val imageFlag: ImageView

        init {
            imageMember = v.findViewById(R.id.imageMember)
            textName = v.findViewById(R.id.textName)
            textNick = v.findViewById(R.id.textNick)
            imageFlag = v.findViewById(R.id.imageFlag)

            v.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    val member = members[position]
                    //Toast.makeText(context, "${member.name}", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("member", member)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.item_layout, parent, false)
        val holder = ViewHolder(itemView)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val member = members[position]
        holder.imageMember.setImageResource(member.imageId)
        holder.textName.text = member.name
        holder.textNick.text = member.nick
        holder.imageFlag.setImageResource(member.flagId)
    }

    override fun getItemCount(): Int {
        return members.size
    }
}