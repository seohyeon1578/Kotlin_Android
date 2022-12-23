package com.example.recicylerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val member = intent.getSerializableExtra("member") as Twice

        val textView:TextView = findViewById(R.id.text_detail)
        val imageView:ImageView = findViewById(R.id.image_detail)

        textView.text = member.name
        imageView.setImageResource(member.imageId)
    }
}