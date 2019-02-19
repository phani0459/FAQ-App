package com.faq.application

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import java.io.InputStream

class ChildFAQActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        val faqPojo : FAQPojo = intent?.extras?.get("DATA") as FAQPojo

        val recyclerView: RecyclerView = findViewById(R.id.faqsList)
        recyclerView.addItemDecoration(ItemDecorator())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ChildFAQAdapter(faqPojo.subFAQs)

    }
}
