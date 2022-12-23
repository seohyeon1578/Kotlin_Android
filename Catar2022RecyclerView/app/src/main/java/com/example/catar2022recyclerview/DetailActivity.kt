package com.example.catar2022recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nation = intent.getSerializableExtra("nation") as Nation

        val imageFlag:ImageView = findViewById(R.id.detail_flag)
        val textName:TextView = findViewById(R.id.detail_name)
        val textGroup:TextView = findViewById(R.id.detail_group)

        imageFlag.setImageResource(nation.flag)
        textName.text = nation.name
        textGroup.text = "Group ${nation.group}"
    }
}