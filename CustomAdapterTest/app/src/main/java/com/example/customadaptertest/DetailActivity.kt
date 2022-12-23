package com.example.customadaptertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val member = intent.getSerializableExtra("member") as Twice

        val imageMember:ImageView = findViewById(R.id.image_member)
        val imageFlag:ImageView = findViewById(R.id.image_flag)
        val textName:TextView = findViewById(R.id.text_name)
        val textNick:TextView = findViewById(R.id.text_nick)

        imageMember.setImageResource(member.imageId)
        imageFlag.setImageResource(member.flag)
        textName.text = member.name
        textNick.text = member.nick
    }
}