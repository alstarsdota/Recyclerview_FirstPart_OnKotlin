package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_firstpart_kotlin.R
import kotlinx.android.synthetic.main.activity_main.*

abstract class MainActivity : AppCompatActivity() {
    var like = true
    var recyclerview: RecyclerView? = null
    abstract var s1: Array<String>
    abstract var s2: Array<String>
    var images = intArrayOf(
        R.drawable.arman,
        R.drawable.zhalgas,
        R.drawable.shavkat,
        R.drawable.baseball,
        R.drawable.basketball,
        R.drawable.billiards,
        R.drawable.coach,
        R.drawable.football,
        R.drawable.box,
        R.drawable.volleyball
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview = findViewById(R.id.recyclerView)
        s1 = resources.getStringArray(R.array.descriptions)
        val myAdapter = MyAdapter(this, s1, images)
        recyclerView.setAdapter(myAdapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
    }

    fun toastClick(view: View?) {
        if (like == true) {
            Toast.makeText(this, "Liked", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Unliked", Toast.LENGTH_LONG).show()
        }
        like = !like
    }
}