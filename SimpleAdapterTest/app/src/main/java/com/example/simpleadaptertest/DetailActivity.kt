package com.example.simpleadaptertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val image = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")
        val nick = intent.getStringExtra("nick")

        val imageView:ImageView = findViewById(R.id.imageView)
        val textName:TextView = findViewById(R.id.textView)
        val textNick:TextView = findViewById(R.id.textView2)

        imageView.setImageResource(image)
        textName.text = name
        textNick.text = nick
    }
}