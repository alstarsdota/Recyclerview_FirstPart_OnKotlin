package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview_firstpart_kotlin.R

class MyAdapter(
    var context: Context,
    var data1: Array<String>,
    var images: IntArray
) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.description.text = data1[position]
        holder.MyImage.setImageResource(images[position])
        holder.mainL.setOnClickListener {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("data1", data1[position])
            intent.putExtra("image", images[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data1.size
    }

    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var description: TextView
        var MyImage: ImageView
        var mainL: RelativeLayout

        init {
            description = itemView.findViewById(R.id.description)
            MyImage = itemView.findViewById(R.id.myImageVIEW)
            mainL = itemView.findViewById(R.id.mainLayout)
        }
    }

}