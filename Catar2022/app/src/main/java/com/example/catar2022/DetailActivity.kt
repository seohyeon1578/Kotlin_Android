package com.example.catar2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val countie = intent.getSerializableExtra("countie") as Nation

        val imageView:ImageView = findViewById(R.id.image_detail)
        val textName:TextView = findViewById(R.id.text_detail_name)
        val textGroup:TextView = findViewById(R.id.text_detail_group)

        imageView.setImageResource(countie.flag)
        textName.text = countie.name
        textGroup.text = "Group ${countie.group}"
    }
}