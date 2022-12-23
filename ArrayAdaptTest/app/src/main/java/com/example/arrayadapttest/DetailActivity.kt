package com.example.arrayadapttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageId = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")

        val textView:TextView = findViewById(R.id.textView)
        val imageView:ImageView = findViewById(R.id.imageView)

        imageView.setImageResource(imageId)
        textView.text = "$name"
    }
}