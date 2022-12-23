package com.example.catar2022

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class NationAdapter(val context: Context, val datas:ArrayList<Nation>):BaseAdapter() {

    override fun getCount(): Int {
        return datas.size
    }

    override fun getItem(p0: Int): Any {
        return datas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view: View
        var holder: Holder

        if(p1 == null){
            val inflater = LayoutInflater.from(context)
            view =inflater.inflate(R.layout.catar2022_layout, p2, false)
            holder = Holder()
            holder.imageView = view.findViewById(R.id.image_flag)
            holder.textName = view.findViewById(R.id.text_name)
            holder.textGroup = view.findViewById(R.id.text_group)
            view.tag = holder
        }else {
            view = p1
            holder = p1.tag as Holder
        }

        val data = datas[p0]

        holder.imageView?.setImageResource(data.flag)
        holder.textName?.text = data.name
        holder.textGroup?.text = "Group ${data.group}"

        return view
    }

    inner class Holder {
        var imageView:ImageView? = null
        var textName:TextView? = null
        var textGroup:TextView? = null
    }
}