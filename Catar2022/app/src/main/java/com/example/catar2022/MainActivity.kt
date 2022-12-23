package com.example.catar2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView:ListView = findViewById(R.id.listView)
        val adapter = NationAdapter(this, counties)

        listView.adapter = adapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val countie = counties[i]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("countie", countie)
            startActivity(intent)
        }
    }
}