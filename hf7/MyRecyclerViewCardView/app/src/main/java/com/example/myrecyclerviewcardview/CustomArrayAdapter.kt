package com.example.myrecyclerviewcardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

data class MyItem(val imageResource: Int, val name:String, val descr:String)

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageView3)
    val nameView: TextView = itemView.findViewById(R.id.name)
    val descrView: TextView = itemView.findViewById(R.id.descr)
}

class CustomArrayAdapter(private val myItemList: List<MyItem>):
        RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_element, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myItemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = myItemList[position]
        holder.imageView.setImageResource(item.imageResource)
        holder.nameView.text = item.name
        holder.descrView.text = item.descr
    }
}