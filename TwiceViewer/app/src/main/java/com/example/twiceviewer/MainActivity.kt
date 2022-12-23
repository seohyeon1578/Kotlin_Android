package com.example.twiceviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val images = intArrayOf(R.drawable.twice1, R.drawable.twice2,
        R.drawable.twice3, R.drawable.twice4,
        R.drawable.twice5, R.drawable.twice6,
        R.drawable.twice7, R.drawable.twice8,
        R.drawable.twice9)
    val names:Array<String> = arrayOf("사나", "나연", "쯔위", "미나",
        "지효", "채영", "다현", "정연", "모모")
    var index = 0
    var imageView:ImageView? = null
    var textView:TextView? = null
    var nameTextView:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        nameTextView = findViewById(R.id.textView2)
        val btn1:Button = findViewById(R.id.button)
        val btn2:Button = findViewById(R.id.button2)
        setDisplay()

        btn1.setOnClickListener {
            btn2.isEnabled = true
            if (index > 0) {
                imageView?.setImageResource(images[--index])

                btn1.isEnabled = index > 0
            }
            setDisplay()
        }

        btn2.setOnClickListener {
            btn1.isEnabled = true
            if(index < images.size - 1) {
                imageView?.setImageResource(images[++index])

                btn2.isEnabled = index < images.size - 1
            }
            setDisplay()
        }
    }

    private fun setDisplay() {
        textView?.text = "${images.size} of ${index + 1}"
        nameTextView?.text = "${names[index]}"
    }
}