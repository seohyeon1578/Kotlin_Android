package com.example.listnertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var textView:TextView? = null
    var cnt = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = "Hello Android"
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        val result = when (v?.id) {
            R.id.btn1 -> "one Button Click"
            R.id.btn2 -> "two Button Click"
            R.id.btn3 -> "three Button Click"
            R.id.btn4 -> "four Button Click"
            R.id.btn5 -> "five Button Click"
            else -> ""
        }
        textView?.text = result
    }
}