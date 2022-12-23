package com.example.bookfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {
    val ENDPoint:String = "https://dapi.kakao.com./v3/search/book?query=%s&page=%d"
    val API_KEY: String = "a43bfcbf9f8cb76c6c8ac77087015261"
    val page: Int = 1
    val books: ArrayList<Book> = ArrayList()
    var adapter:BookAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val task = BookThreadTask()
        task.execute("눈")
        adapter = BookAdapter(this)
        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter

        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager

        val divi = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(divi)
    }

    fun search(query:String?):String? {
        var str: String
        var result = ""
        val strURL = String.format(ENDPoint, query, page)

        try {
            val url = URL(strURL)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.setRequestProperty("Authorization", "KakaoAK ${API_KEY}")
            conn.connect()

            if (conn.responseCode == HttpURLConnection.HTTP_OK) {
                val tmp = InputStreamReader(conn.inputStream, StandardCharsets.UTF_8)
                var reader = BufferedReader(tmp)
                var buffer = StringBuffer()

                while (reader.readLine().also { str = it } != null) {
                    buffer.append(str)
                }

                result = buffer.toString()
            }
        } catch(e:IOException) {
            e.printStackTrace()
        }

        return result
    }

    fun parsing(json:String?) {
        try {
            this.adapter?.clear()
            val root = JSONObject(json)
            val meta = root.getJSONObject("meta")
            val books = root.getJSONArray("documents")

            for (i in 0 until books.length()) {
                val book = books.getJSONObject(i)
                val title = book.getString("title")
                val publisher = book.getString("publisher")
                val authors = book.getJSONArray("authors").join(",")
                val thumbnail = book.getString("thumbnail")
                val price = book.getInt("price")
                val url = book.getString("url")

                val item = Book(title, publisher, authors, thumbnail, price, url)

                this.adapter?.add(item)
            }
            adapter?.notifyDataSetChanged()
        } catch (e:JSONException) {
            e.printStackTrace()
        }
        Log.d("BookFinder", "${this.books.size}")
    }

    inner class BookThreadTask: ThreadTask<String?, String?>() {
        override fun onPreExecute() {
        }

        override fun doInBackground(arg: String?): String? {
            return search(arg)
        }

        override fun onPostExecute(result: String?) {
            parsing(result)
        }
    }
}