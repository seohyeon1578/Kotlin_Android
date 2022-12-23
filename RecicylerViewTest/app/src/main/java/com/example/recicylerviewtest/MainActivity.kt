package com.example.recicylerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val names:Array<String> = arrayOf("사나", "나연", "쯔위", "미나",
        "지효", "채영", "다현", "정연", "모모")
    val nicks:Array<String> = arrayOf("사", "임나연", "주희", "미나리",
        "찐", "챙", "독다", "또검", "모구리")
    val images = intArrayOf(R.drawable.twice1, R.drawable.twice2,
        R.drawable.twice3, R.drawable.twice4,
        R.drawable.twice5, R.drawable.twice6,
        R.drawable.twice7, R.drawable.twice8,
        R.drawable.twice9)
    val nations:Array<String> = arrayOf("jp", "kr", "tw", "jp",
        "kr", "kr", "kr", "kr", "jp")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        val members:ArrayList<Twice> = ArrayList()

        for (i in names.indices) {
            val flag = when(nations[i]) {
                "kr" -> R.drawable.kr
                "jp" -> R.drawable.jp
                "tw" -> R.drawable.tw
                else -> R.drawable.kr
            }
            val member = Twice(names[i], images[i], nicks[i], flag)

            members.add(member)
        }

        val adapter = TwiceAdapter(this, members)
        recyclerView.adapter = adapter

        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager

        val divi = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(divi)
    }
}