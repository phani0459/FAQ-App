package com.faq.application

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import java.io.InputStream

class FAQActivity : AppCompatActivity() {

    val gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        var json_string = ""
        val file_name = "faqs.json"
        /*json_string = application.assets.open(file_name).bufferedReader().apply {
            use {
                it.readText()
            }
        }*/

        val inputStream: InputStream = assets.open(file_name)
        try {
           json_string = inputStream.bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            inputStream.close()
            inputStream.bufferedReader().close()
        } finally {
            inputStream.close()
            inputStream.bufferedReader().close()
        }

        val faqsList: List<FAQPojo> = gson.fromJson(json_string, Array<FAQPojo>::class.java).toList()

        val recyclerView: RecyclerView = findViewById(R.id.faqsList)
        recyclerView.addItemDecoration(ItemDecorator())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FAQAdapter(faqsList)

    }
}
