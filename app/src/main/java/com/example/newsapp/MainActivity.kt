package com.example.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val item=fetchData()
        val  adapter: NewsListAdapter =NewsListAdapter(item,this)
        recyclerView.adapter=adapter
    }

    private fun fetchData(): ArrayList<String> {
        val list=ArrayList<String>()
        for(i in 0 until 100){
            list.add("Item $i")
        }
        return list;
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this,"Clicked item is $item", Toast.LENGTH_SHORT).show()
    }
}