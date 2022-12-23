package com.example.customadaptertest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TwiceAdapter(context: Context, members:ArrayList<Twice>):BaseAdapter() {
    val context: Context
    val members: ArrayList<Twice>

    init {
        this.context = context
        this.members = members
    }

    override fun getCount(): Int {
        return members.size
    }

    override fun getItem(p0: Int): Any {
        return members[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View
        var holder:ViewHolder

        if(p1 == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.layout_twice, p2, false)
            holder = ViewHolder()
            holder.imageMember = view.findViewById(R.id.imagepost)
            holder.imageFlag = view.findViewById(R.id.imageflage)
            holder.textName = view.findViewById(R.id.textName)
            holder.textNick = view.findViewById(R.id.textNick)
            view.tag = holder
        } else {
            view = p1
            holder = p1.tag as ViewHolder
        }

        val member = members[p0]

        holder.imageMember?.setImageResource(member.imageId)
        holder.imageFlag?.setImageResource(member.flag)
        holder.textName?.text = "${member.name}"
        holder.textNick?.text = "${member.nick}"

        return view
    }

    inner class ViewHolder {
        var imageMember:ImageView? = null
        var imageFlag:ImageView? = null
        var textName:TextView? = null
        var textNick: TextView? = null
    }
}