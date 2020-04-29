package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview_firstpart_kotlin.R

class SecondActivity : AppCompatActivity() {
    var image: ImageView? = null
    var textView: TextView? = null
    var like = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        image = findViewById(R.id.myImageVIEW)
        textView = findViewById(R.id.description)
        val desc = intent.getStringExtra("data1")
        val imID = intent.getIntExtra("image", 0)
        image.setImageResource(imID)
        textView.setText(desc)
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