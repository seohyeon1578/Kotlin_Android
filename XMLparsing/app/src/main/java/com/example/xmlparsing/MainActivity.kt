package com.example.xmlparsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {
    val END_POINT = "http://apis.data.go.kr/6270000/getTourKorAttract/getTourKorAttractList?ServiceKey=%s&pageNo=%d&numOfRows=10"
    val KEY = "ZgGKqYwRYT%2FCl0H5xEowPF8NzgWoBStTDqduub1m12t3GeAY9dmVitguWV5pRBUFpKExZJx8c4ZXBOTe5wt8OQ%3D%3D"
    var page = 1
    var adapter:AttrAdapter? = null
    var prevBtn:Button? = null
    var nextBtn:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        adapter = AttrAdapter(this)
        recyclerView.adapter = adapter

        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager

        val deco = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(deco)

        getItem()

        prevBtn = findViewById(R.id.prev)
        nextBtn = findViewById(R.id.next)

        prevBtn?.setOnClickListener {
            page--
            getItem()
        }

        nextBtn?.setOnClickListener {
            page++
            getItem()
        }
    }

    private fun getItem() {
        prevBtn?.isEnabled = page > 1
        val task = AttThreadTask()
        task.execute("")
    }

    fun request() {
        val strURL = String.format(END_POINT, KEY, page)
        val url = URL(strURL)
        val inputStream = url.openStream()
        var tag: String
        var attract: Attracct? = null
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(InputStreamReader(inputStream, "UTF-8"))
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                when (eventType) {
                    XmlPullParser.START_DOCUMENT -> adapter?.clear()
                    XmlPullParser.START_TAG -> {
                        tag = parser.name
                        if (tag == "item") {
                            attract = Attracct()
                        } else if (tag == "attractname") {
                            attract?.name = parser.nextText()
                            Log.d("xmlparser", parser.nextText())
                        } else if (tag == "address") {
                            attract?.address = parser.nextText()
                        } else if (tag == "homepage") {
                            attract?.homePage = parser.nextText()
                        }
                    }
                    XmlPullParser.END_TAG -> {
                        tag = parser.name
                        if (tag == "item") {
                            adapter?.add(attract!!)
                        }
                    }
                }
                eventType == parser.next()
            }
        }catch (e:IOException){
            e.printStackTrace()
        }
    }

    inner class AttThreadTask:ThreadTask<String?, String?>() {
        override fun onPreExecute() {

        }

        override fun doInBackground(arg: String?): String? {
            request()
            return ""
        }

        override fun onPostExecute(result: String?) {
            adapter?.notifyDataSetChanged()
        }
    }
}